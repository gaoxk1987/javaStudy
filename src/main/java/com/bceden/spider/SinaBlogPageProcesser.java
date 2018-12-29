package com.bceden.spider;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class SinaBlogPageProcesser implements PageProcessor {

    private Site site = Site.me().setDomain("my.oschina.net");

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://blog\\.sina\\.com\\.cn/s/blog_5c3e721a0102[a-z]*\\.html").all();
        System.out.println(links.size());
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='artical']/div[@class='articalTitle']/h2").toString());
        page.putField("content", page.getHtml().$("div.articalContent   newfont_family").toString());
        page.putField("tags",page.getHtml().xpath("//div[@class='articalTag']/span/text()").all());
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) {
        Spider.create(new SinaBlogPageProcesser()).addUrl("http://blog.sina.com.cn/s/blog_5c3e721a0102vjri.html")
             .addPipeline(new ConsolePipeline()).run();
    }
}