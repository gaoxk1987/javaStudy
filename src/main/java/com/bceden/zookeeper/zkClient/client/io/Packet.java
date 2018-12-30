package com.bceden.zookeeper.zkClient.client.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.jute.BinaryOutputArchive;
import org.apache.jute.Record;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.proto.ConnectRequest;
import org.apache.zookeeper.proto.ReplyHeader;
import org.apache.zookeeper.proto.RequestHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bceden.zookeeper.zkClient.watcher.WatchRegistration;

/**
 * This class allows us to pass the headers and the relevant records around.
 */
public class Packet {
    private static final Logger LOG = LoggerFactory.getLogger(Packet.class);
	
    RequestHeader requestHeader;

    ReplyHeader replyHeader;

    Record request;

    Record response;

    ByteBuffer bb;

    /** Client's view of the path (may differ due to chroot) **/
    String clientPath;
    /** Servers's view of the path (may differ due to chroot) **/
    String serverPath;

    boolean finished;

    AsyncCallback cb;

    Object ctx;

    WatchRegistration watchRegistration;

    public boolean readOnly;

    /** Convenience ctor */
    Packet(RequestHeader requestHeader, ReplyHeader replyHeader,
           Record request, Record response,
           WatchRegistration watchRegistration) {
        this(requestHeader, replyHeader, request, response,
             watchRegistration, false);
    }

    Packet(RequestHeader requestHeader, ReplyHeader replyHeader,
           Record request, Record response,
           WatchRegistration watchRegistration, boolean readOnly) {

        this.requestHeader = requestHeader;
        this.replyHeader = replyHeader;
        this.request = request;
        this.response = response;
        this.readOnly = readOnly;
        this.watchRegistration = watchRegistration;
    }

    public void createBB() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BinaryOutputArchive boa = BinaryOutputArchive.getArchive(baos);
            boa.writeInt(-1, "len"); // We'll fill this in later
            if (requestHeader != null) {
                requestHeader.serialize(boa, "header");
            }
            if (request instanceof ConnectRequest) {
                request.serialize(boa, "connect");
                // append "am-I-allowed-to-be-readonly" flag
                boa.writeBool(readOnly, "readOnly");
            } else if (request != null) {
                request.serialize(boa, "request");
            }
            baos.close();
            this.bb = ByteBuffer.wrap(baos.toByteArray());
            this.bb.putInt(this.bb.capacity() - 4);
            this.bb.rewind();
        } catch (IOException e) {
            LOG.warn("Ignoring unexpected exception", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("clientPath:" + clientPath);
        sb.append(" serverPath:" + serverPath);
        sb.append(" finished:" + finished);

        sb.append(" header:: " + requestHeader);
        sb.append(" replyHeader:: " + replyHeader);
        sb.append(" request:: " + request);
        sb.append(" response:: " + response);

        // jute toString is horrible, remove unnecessary newlines
        return sb.toString().replaceAll("\r*\n+", " ");
    }
}
