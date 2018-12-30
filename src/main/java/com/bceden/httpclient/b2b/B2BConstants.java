/*
 * $Id: B2BConstants.java,v 1.56 2013/08/19 00:02:42 sunw Exp $
 * Copyright(c) 2000-2007 HC360.COM, All Rights Reserved.
 */
package com.bceden.httpclient.b2b;


/**
 * 这是整个系统用到的相关常量定义类
 * 
 * @author:
 * 
 * @modifyauthor:zengjuemin, Guo Gang
 * 
 * @version:v1.0 Date:2007-3-14
 *  
 */
public interface B2BConstants {
	/** 商铺地址模版 */
	public final static String TEMPLATE_SHOP_URL = "http://%%1%%.b2b.hc360.com";
	
    public final static String MESSAGES_KEY = "b2b.resource.messages";

    public final static String DB_CFG_PREFIX = "db.cfg";

    public final static String DB_CFG_MARKET = DB_CFG_PREFIX + ".market";

    public final static String DB_CFG_DETAIL = DB_CFG_PREFIX + ".detail";

    public final static String DB_CFG_MAIL = DB_CFG_PREFIX + ".mail";

    public final static String DB_CFG_SMS = DB_CFG_PREFIX + ".sms";

    public final static String DB_CFG_SHOW = DB_CFG_PREFIX + ".show";

    public final static String DB_CFG_KEYWORD = DB_CFG_PREFIX + ".keyword";

    public final static String DB_CFG_BUSIN = DB_CFG_PREFIX + ".busin";

    public final static String DB_CFG_SEARCH = DB_CFG_PREFIX + ".search";

    public final static String DB_CFG_ORDER = DB_CFG_PREFIX + ".order";

    public final static String DB_CFG_CHAT = DB_CFG_PREFIX + ".chat";

    public final static String DB_SCHEMA_PREFIX = "db.schema";

    public final static String DB_SCHEMA_HC = DB_SCHEMA_PREFIX + ".hc";

    public final static String DB_SCHEMA_DETAIL = DB_SCHEMA_PREFIX + ".detail";

    public final static String DB_SCHEMA_MAIL = DB_SCHEMA_PREFIX + ".mail";

    public final static String DB_SCHEMA_SMS = DB_SCHEMA_PREFIX + ".sms";

    public final static String DB_SCHEMA_KEYWORD = DB_SCHEMA_PREFIX
            + ".keyword";

    public final static String DB_SCHEMA_BUSIN = DB_SCHEMA_PREFIX + ".busin";

    public final static String DB_SCHEMA_ORDER = DB_SCHEMA_PREFIX + ".order";

    public final static String DB_SCHEMA_CHAT = DB_SCHEMA_PREFIX + ".chat";

    public final static String MEMBER_STATUS_UNCHECKED = "0";// 未审核状态

    public final static String MEMBER_STATUS_CHECKED = "1";// 审核通过

    public final static String MEMBER_STATUS_REFUSE = "1";// 已经审核为拒绝通过

    public static int MEMBER_TYPE_FREE = 0; // 普通会员
    
    public static int MEMBER_CONSTWEBSITE = 1; // 建站会员

    public static int MEMBER_TYPE_BUYER = 1; // 买家会员

    public static int MEMBER_TYPE_BIGBUYER = 2; // 大买家会员

    public static int MEMBER_TYPE_TRIAL = 3; // 试用买卖通会员

    public static int MEMBER_TYPE_NORMAL = 4; // 买卖通会员

    public static int MEMBER_TYPE_VIP = 5; // 买卖通VIP会员

    public static int MEMBER_TYPE_SILVER = 6; // 买卖通银牌会员

    public static int MEMBER_TYPE_GOLD = 7; // 买卖通金牌会员

    public static int MEMBER_TYPE_PLATIUM = 8; // 买卖通铂金会员

    public static final String VERIFYCODE = "hcVerifyCode"; // Session中验证码的SessionKey

    public static String SESSION_KEY_OBJECT = "objectSession"; // 获得ObjectSession的key值

    public static final String CHARTSET_GBK = "GBK";

    public static final String CHARTSET_ISO = "ISO-8859-1";
    
    public static final String CHARTSET_UTF8 = "UTF-8";
    
    public static final String CHARTSET_GB2312 = "GB2312";
    
    public static String SESSION_KEY = "webSession"; // 取WebSession对象的key值

    public static final String HAS_MMT_PRIVILEGE = "1"; // 是否有买卖通权限

    // pertinent with paginate
    public static final int DEF_PAGE_VIEW_NUM = 20; // 分页默认显示条数

    public static final int DEF_CURRENT_PAGE = 1; // 默认当前页数

    public static final int DEF_PAGE_SIZE = 10; // 分页默认显示条数

    // pertinent with hibernate load path
    // public static final String DEF_HIBERNATE_LOAD_PATH = File.separator +
    // "util" + File.separator + "config";
    public static final String DEF_HIBERNATE_LOAD_PATH = "/util/config";

    public static final String B2BMANAGE_PATH = "/b2bmanage";

    /* 图片相关 */
    public static final int IMAGE_INFOTYPE_CHANCE = 0; // 商机

    public static final int IMAGE_INFOTYPE_PRODUCT = 1; // 产品

    public static final int IMAGE_INFOTYPE_COMPANY = 2; // 公司

    public static final int IMAGE_INFOTYPE_PROJECT = 3; // 方案案例

    public static final int IMAGE_INFOTYPE_TRENDS = 4; // 公司动态

    public static final int IMAGE_INFOTYPE_HR = 5; // 人才

    public static final int IMAGE_INFOTYPE_DOC_OF_PRODUCT = 6; // 产品文档

    public static final int IMAGE_INFOTYPE_COMPANY_LOGO = 7; // 公司Logo图片

    public static final int IMAGE_INFOTYPE_COMPANY_VIEW = 8; // 公司展示图

    public static final int IMAGE_INFOTYPE_COMPANY_VIEW_WHOLE = 9; // 公司整体展示图

    public static final int IMAGE_INFOTYPE_COMPANY_ZHANGESU = 10; // 证书及图片

    public static final int IMAGE_FILECLASS_ZHANGESU = 0; // CA证书及电子签章(原为证书图片)

    public static final int IMAGE_FILECLASS_ZHIZHAO = 1; // 执照图片

    public static final int IMAGE_FILECLASS_COMPANY = 2; // 公司图片

    public static final int IMAGE_FILECLASS_OWNER_PIC = 3; // 法人照片

    public static final int IMAGE_FILECLASS_INDIVIDUAL = 4; // 个人照片

    public static final int IMAGE_FILECLASS_COMPANY_LOGO = 5; // 公司logo

    public static final int IMAGE_FILECLASS_POSTER_VIEW = 6; // 海报展示图

    public static final int IMAGE_FILECLASS_ZHANGESU_INTERNATION = 1; // 国际证书

    public static final int IMAGE_FILECLASS_ZHANGESU_COMMON = 2; // 基础证书

    public static final int IMAGE_FILECLASS_ZHANGESU_COMMONLY = 3; // 一般证书
    
    public static final int IMAGE_FILECLASS_ZHANGESU_TAX = 24;		//税务证书

    public static final int IMAGE_FILECLASS_ZHANGESU_HC360 = 26;    //慧聪网证书
    
    public static final int IMAGE_ACTIVITY_PIC = 18; // 活动标识
    
    public static final int IMAGE_NOTICEIMG_PIC = 19; // 商务中心通知广告图片
    
    public static final int IMAGE_NOTICEFLASH_PIC = 20; // 商务中心通知广告flash
    
    public static final int IMAGE_AWARDHEAD_PIC = 21; // 十大评选头图片
    
    public static final int IMAGE_AWARDTAIL_PIC = 22; // 十大评选尾图片
    
    public static final int IMAGE_FRIENDLINK_PIC = 23; // 友情链接
    
    public static final int IMAGE_ALBUM_PIC = 24; // 相册
    
    public static final int IMAGE_SITE_COMPLOGO = 25; //自助建站公司LOGO
    
    public static final int IMAGE_SITE_COMPPOSTER = 26; //自助建站公司海报
    
    public static final int IMAGE_SITE_SHOPSIGN = 27; //自助建站2.0招牌背景图
    
    public static final int IMAGE_SITE_FLASHADST1SC1 = 28; //自助建站FLASH广告场样式1场景1
    
    public static final int IMAGE_SITE_FLASHADST1SC2 = 29; //自助建站FLASH广告场样式1场景2
    
    public static final int IMAGE_SITE_FLASHADST1SC3 = 30; //自助建站FLASH广告场样式1场景3
    
    public static final int IMAGE_SITE_FLASHADST1SC4 = 31; //自助建站FLASH广告场样式1场景4
    
    public static final int IMAGE_SITE_FLASHADST2SC1 = 32; //自助建站FLASH广告场样式2场景1
    
    public static final int IMAGE_SITE_FLASHADST2SC2 = 33; //自助建站FLASH广告场样式2场景2
    
    public static final int IMAGE_SITE_FLASHADST2SC3 = 34; //自助建站FLASH广告场样式2场景3
    
    public static final int IMAGE_SITE_FLASHADST2SC4 = 35; //自助建站FLASH广告场样式2场景4
    
    public static final int IMAGE_SITE_ADBG = 36; //多图广告图背景片   
    
    public static final int IMAGE_SITE_SDBG = 37; //单图图广告图背景片
    
    public static final int IMAGE_SITE_INNERBG = 38; //内背景图
    
    public static final int IMAGE_SITE_OUTERBG = 39; //外背景图
    
    public static final int IMAGE_SITE_SELNAVBG = 40; //选中导航背景图片
    
    public static final int IMAGE_SITE_UNSELNAVBG = 41; //未选中导航背景图片
    
    public static final int IMAGE_SITE_COLUMNBG = 42; //栏目名称背景图片
    
    public static final int IMAGE_FLASHADST1_SC1 = 43; //推荐FLASH首页-样式1-场景1图片
    
    public static final int IMAGE_FLASHADST1_SC2 = 44; //推荐FLASH首页-样式1-场景2图片 
    
    public static final int IMAGE_FLASHADST2_SC1 = 45; //推荐FLASH首页-样式2-场景1图片
    
    public static final int IMAGE_FLASHADST2_SC2 = 46; //推荐FLASH首页-样式2-场景2图片
    
    public static final int IMAGE_FLASHHOME_BG = 47; //Flash背景图片
    
    public static final int IMAGE_ONLINE_BG = 48; //在线客服背景图
    
    public static final int IMAGE_AD_FLASH = 49; //广告Flash
    
    public static final int IMAGE_HOME_FLASH = 50; //首页Flash
    
    public static final int IMAGE_PAGE_HEAD = 51; //页头背景图
    
    public static final int IMAGE_PAGE_FOOT = 52; //页尾背景图
  
    public static final int IMAGE_NOTICEIMG1_PIC = 19; // 商务中心通知公告图片
    
    public static final int IMAGE_ICON_PIC = 76; // 后台图标
    
    public static final int IMAGE_CHATEVAL_PIC = 77; //洽谈会评价图片
    
    public static final int IMAGE_SITEALBUM_PIC = 78; //实地拍照相册图片   
    
    public static final int IMAGE_INFOTYPE_PORTRAIT = 79;//采购联系人图片
    
    public static final int IMAGE_WEIBOBG_PIC = 80; //企业微博背景
    
    public static final int IMAGE_FRANCHISE_PIC = 81; //特版经营
    
    public static final int IMAGE_PERSONALAUTHUP_PIC = 82; //个人认证身份证正面
    
    public static final int IMAGE_PERSONALAUTHDOWN_PIC = 83; //个人认证身份证反面
    
    public static final int IMAGE_ORDERPORTAL_PIC = 84; //订单portal双图片
    
    public static final int IMAGE_ORDERPORTALSINGLE_PIC = 85; //订单portal冠名图片
    
    public static final int IMAGE_ORDERPORTALWINDOW_PIC = 86; //订单portal弹窗图片
    
    public static final int IMAGE_ORDERPORTALBRAND_PIC = 87; //订单portal品牌图片
       
    public static final int IMAGE_AREAHOME_PIC = 88; //行业首页图片
    
    public static final int IMAGE_COMPLAIN_PIC = 89; //投诉附件
    
    /** 企业网站推荐图片相关类型 */
    public static final int WEBSITE_BANNER_BG = 1;//招牌背景图
    
    public static final int WEBSITE_AD_BG = 2;//广告背景图	
    
    public static final int WEBSITE_IN_BG = 3;//内背景图库
    
    public static final int WEBSITE_OUT_BG = 4;//外背景图
    
    public static final int WEBSITE_NAVG_BG = 5;//导航背景图
    
    public static final int WEBSITE_COLUMN_BG = 6;//栏目名称背景图
    
    public static final int WEBSITE_FLASH_BG = 7;//Flash首页背景图
    
    public static final int WEBSITE_VIPOUT_BG = 8;//VIP外会员背景图	
    
    public static final int WEBSITE_TOP_BG = 9;//页头背景图
    
    public static final int WEBSITE_FOOTER_BG = 10;//页尾背景图

    public static final int WEBSITE_NAVEALL_BG = 11;//导航整体背景图	
    // 切图服务器相关配置，对图片和文档的上传、删除操作都在此服务器上进行
    // public static final String IMAGE_SERVER = "http://192.168.12.38:8084/";
    // public static final String
    // PICVIEWPATH="http://192.168.12.38:8084/b2bimage/pic/";
    public static final String PICPATH = "/imgs/";

    public static final String PROJECTITEM = "Market";

    // 各种图片存放路径
    public static final String PROPATH = "product";

    public static final String HANDBOOKPATH = "handbook";

    public static final String CORPPATH = "company";

    public static final String BUSPATH = "busin";

    public static final String CORINFOPATH = "corpinfo";

    public static final String PROJECTPATH = "project";

    public static final String HRPATH = "hr";

    public static final String CREDIT = "credit";

    public static final String SHOPLOGO = "shoplogo";

    public static final String SHOPSHOWPIC = "shopshowpic";

    public static final String SHOPBANNER = "shopbanner";

    public static final String TMPPATH = "tmppic";
    
    // 中高图前缀定义
    public static final String I_PIC = "i_"; // 中高图
    
    
    // 300x300图前缀定义
    public static final String PIC_300 = "300x300"; // 300x300尺寸
    
    // 400x400图前缀定义
    public static final String PIC_400 = "400x400"; // 400x400尺寸
    
    // 大小图前缀定义
    public static final String L_PIC = "l_"; // 小图

    public static final String M_PIC = "m_"; // 中图

    // 大小图图片大小限制
    public static final int L_PIC_WIDTH = 70; // 小图

    public static final int M_PIC_WIDTH = 180; // 中图

    public static final int PIC_SIZE_LIMIT = 2048;

    // 图片水印文字
    public static final String PIC_WATER = "www.hc360.com";

    // pertinent with image
    public static final int IMAGE_MAX_SIZE = 204800;

    public static final int IMAGE_MAX_WIDTH = 400;

    public static final int IMAGE_MAX_HEIGHT = 400;

    public static final int DOCU_MAX_SIZE = 2097152;

    /* 图片相关 */

    /* 静态页相关 */
    // 静态页域名
    public static final String HTM_SERVER = "http://b2b.hc360.com";

    // 信息类型
    public static final String SUPPLYINFO = "supply"; // 供应

    public static final String BUYINFO = "buy"; // 求购

    public static final String BIDINFO = "bid"; // 招标

    public static final String USEDINFO = "used"; // 二手

    public static final String COOPERATEINFO = "cooperate"; // 合作

    public static final String LEASEHOLDINFO = "leasehold"; // 租赁

    public static final String AGENTINFO = "agent"; // 代理

    public static final String BUILDINGINFO = "building"; // 在建工程

    public static final String PRODUCTINFO = "product"; // 产品

    public static final String COMPANYINFO = "company"; // 企业

    /* 终极页相关 */

    /**
     * DBServer配置 zyj add 2005-03-15
     */
    // public static final String DEF_DB = "publicdb";
    //
    // public static final String PUBLIC_DB = "publicdb";
    //
    // public static final String MARKET_DB = "marketdb";
    //
    // public static final String LOG_DB = "publicdb";
    //
    // public static final String MAIL_DB = "mail";
    //
    // public static final String HR_DB = "marketdb";
    //
    // public static final String INFO_DB = "publishdb";
    //
    // public static final String SMS_DB = "sms";
    // /**
    // * 旧版配置 zyj del 2006.1.10
    // */
    // public static final String DEF_DB_USERNAME = "hc";
    //
    // public static final String SINOBNET_DB_USERNAME = "hc";
    //
    // public static final String NEWS_DB_USERNAME = "hc";
    //
    // public static final String HR_DB_USERNAME = "hc";
    //
    // public static final String MAIL_DB_USERNAME = "mail";
    //
    // public static final String LOG_DB_USERNAME = "hc";
    //
    // public static final String HC_DB_USERNAME = "newhc";
    //
    // public static final String SMS_DB_USERNAME = "sms";
    //
    //
    // /**
    // * 旧版配置 zyj del 2006.1.10
    // */
    // public static final String publisho_DB_USERNAME = "laser";
    //
    // public static final String infodb1_DB_USERNAME = "wujin";
    //
    // public static final String infodb2_DB_USERNAME = "house";
    //
    // public static final String infodb3_DB_USERNAME = "gift";
    //
    // public static final String publish5_DB_USERNAME = "news";
    //
    // public static final String publisht_DB_USERNAME = "it";
    /**
     * httpSession相关配置信息el zyj add 2005-03-16
     */
    // public static ObjectSession objectSession;
    /**
     * 业务相关
     */
    // 后台添加的信息自动审核，此处为CheckMan记录的审核人
    public static final String DEF_CHECKMAN = "自动审核";

    // 前台会员修改信息时，记录的修改人
    public static final String B2B_WHOUPDATE = "会员修改";

    public static final String B2B_WHOINPUT = "会员新增";

    public static final String B2B_WHODELETE = "会员删除";

    // 审核状态
    public static final String DEF_F_CHECKED = "0"; // 未审

    public static final String DEF_B_CHECKED = "1"; // 审核通过

    public static final String CHECKED_REFUSE = "2"; // 拒审

    public static final String CHECKED_SHANGKAN = "9"; // 上刊数据
    
    //企业状态
    public static final String DEF_B_COMMEND = "1"; // 推荐
    public static final String DEF_B_UNCOMMEND = "0";//取消推荐

    // 默认生成静态页状态
    public static final String DEF_OPERSTATE = "0"; // 静态页未生成

    public static final String OPERSTATE_CREATED = "1"; // 静态页已生成

    public static final String OPERSTATE_WELL_DELETE = "3"; // 静态页需删除

    public static final String OPERSTATE_DELETED = "4"; // 静态页已删除

    // 默认生成全文文本状态
    public static final String DEF_SEARCHSTATE = "0"; // 全文检索未载入

    public static final String SEARCHSTATE_IMPORTED = "1"; // 全文检索已载入

    public static final String SEARCHSTATE_DELETED = "3"; // 全文检索已删除

    // L_Type VARCHAR2(20) 操作类型：(新增、修改、删除、审核、拒审、重发、)
    public static final String DEF_LOG_ADD = "新增";

    public static final String DEF_LOG_MODIFY = "修改";

    public static final String DEF_LOG_DEL = "删除";

    public static final String DEF_LOG_PASS = "审核";

    public static final String DEF_LOG_REFUSE = "拒审";

    public static final String DEF_LOG_REPEATE = "重发";

    public static final String DEF_LOG_COMMEND = "推荐";

    public static final String DEF_LOG_OFFLINE = "撤回";

    /**
     * 商机相关
     */
    // 后台商机表
    public static final String BUSINCHANCE = "BusinChance";

    public static final String CORTABLE = "CorTable";

    // 商机浏览天数
    public static final int VIEWLIMIT = 5;

    // 在线商机表
    public static final String ONBUSINCHANCE = "OnBusinChance";

    public static final String ONCORTABLE = "OnCorTable";

    // 编辑邮件地址
    public static final String MAIL_EDIT = "edit@hc360.com";

    // 重发商机条数限制：买卖通会员200/天,银牌会员：300	、金牌会员：400、铂金会员：500	、VIP会员：600
    public static final int BUSIN_FREE_LIMIT = 0;

    public static final int BUSIN_BUYER_LIMIT = 0;

    public static final int BUSIN_MMT_LIMIT = 200;

    public static final int MEMBER_MMT_SILVER_LIMIT=300;
    
    public static final int MEMBER_MMT_GOLD_LIMIT=400;
    
    public static final int MEMBER_MMT_PLATIUM_LIMIT=500;
    
    public static final int BUSIN_MMT_VIP_LIMIT = 600;

    // 普通会员发布商机限制条数
    public static final int BUSIN_PUB_FREE_LIMIT = 300;

    // 会员类型、等级等公共定义
    public static final String MEMBER_FREE = "0"; // 普通会员

    public static final String MEMBER_BUYER = "1"; // 买家会员

    public static final String MEMBER_BIGBUYER = "2"; // 大买家会员

    public static final String MEMBER_MMT_TRYOUT = "3"; // 试用买卖通会员

    public static final String MEMBER_MMT = "4"; // 买卖通会员

    public static final String MEMBER_MMT_VIP = "5"; // 买卖通VIP会员

    public static final String MEMBER_MMT_SILVER = "6"; // 买卖通银牌会员

    public static final String MEMBER_MMT_GOLD = "7"; // 买卖通金牌会员

    public static final String MEMBER_MMT_PLATIUM = "8"; // 买卖通铂金会员

    public static final String IS_AREA_NORMAL = "0"; // 本行业

    public static final String IS_AREA_OTHER = "1"; // 其他行业

    public static final String STATES_NORMAL = "0"; // 有效

    public static final String STATES_DELETE = "1"; // 删除

    public static final String DEF_VIEW_NAME = "公司名称";

    public static final String NEWSAREADID = "999";

    // 产品、商机数量限制　免费会员：500、买卖通会员：500、银牌会员：500 、金牌会员：800 、铂金会员：1000	VIP会员：1500
    public static final int VIP_MAX_PRODUCT_LIMIT = 1500; // VIP会员发布产品最大数量

    public static final int MMT_MAX_PRODUCT_LIMIT = 500; // MMT会员发布产品最大数量
    
    public static final int PLATIUM_MAX_PRODUCT_LIMIT = 1000; //铂金会员最大发布产品数
    
    public static final int SILVER_MAX_PRODUCT_LIMIT = 500; //银牌会员最大发布产品数
    
    public static final int GOLD_MAX_PRODUCT_LIMIT = 800; //金牌会员最大发布产品数
    
    
    /*********产品重发次数定义*************/
    //免费会员：不可重发；买卖通会员：200、银牌会员：300	、金牌会员：400、铂金会员：500	、VIP会员：600
    
    
    
    /**买卖通重发数*/
    public static final int MMT_MAX_PRODUCT_REPEAT_LIMIT = 200;
    /**银牌重发数*/
    public static final int SILVER_MAX_PRODUCT_REPEAT_LIMIT = 300;
    /**金牌重发数*/
    public static final int GOLD_MAX_PRODUCT_REPEAT_LIMIT = 400;
    /**铂金重发数*/
    public static final int PLATIUM_MAX_PRODUCT_REPEAT_LIMIT = 500;
    /**VIP重发数*/
    public static final int VIP_MAX_PRODUCT_REPEAT_LIMIT = 600;
    
    
    
    /*********产品重发次数定义*************/
    
    

    // 系统域名，用于商铺域名组合.
    public static final String SYSURL = "http://b2b.hc360.com/";

    // 产品，商机，企业关键字信息
    public static final String INFO_TYPE_BC = "0";

    public static final String INFO_TYPE_PROD = "1";

    public static final String INFO_TYPE_CORP = "2";

    /* 图片相关常量 */

    /** 上传多图片页面索引 */
    public static final int IMG_MULTI_PAGE = 0;

    /** 上传单图片页面索引 */
    public static final int IMG_SINGLE_PAGE = 1;

    /** 上传图片响应索引 */
    public static final int IMG_UP_ACTION = 2;

    /** 删除图片响应索引 */
    public static final int IMG_DEL_ACTION = 3;

    /** 修改图片响应索引 */
    public static final int IMG_EDIT_NOTES_ACTION = 4;

    /** 直接上传图片页面索引 */
    public static final int IMG_UP_FORMAL_PAGE = 5;

    /** 上传证书页面索引 */
    public static final int IMG_CERTIFICATE_PAGE = 6;

    /** 邮件附件页面索引 */
    public static final int IMG_MAIL_ACCESSORY_PAGE = 7;

    /** 邮件附件响应索引 */
    public static final int IMG_MAIL_ACCESSORY_ACTION = 8;

    /** 生成排名证书响应索引 */
    public static final int IMG_AWARD_CERTIFICATE_ACTION = 9;

    /** Manage后台上传全景图索引 */
    public static final int IMG_MANAGE_PIC360_UPLOAD = 10;

    /** Manage后台修改全景图索引 */
    public static final int IMG_MANAGE_PIC360_EDIT = 11;

    /** 前台修改全景图索引 */
    public static final int IMG_FRONT_PIC360_EDIT = 12;

    /** 上传BANNER图片页面索引 */
    public static final int IMG_BANNER_PAGE_INDEX = 13;

    /** 上传HandUpBanner图片页面索引 */
    public static final int IMG_HANDUPBANNER_PAGE_INDEX = 14;

    /** 上传BUTTON图片页面索引 */
    public static final int IMG_BUTTON_PAGE_INDEX = 15;

    /** 上传HandUpButton图片页面索引 */
    public static final int IMG_HANDUPBUTTON_PAGE_INDEX = 16;

    /* 图片相关结束 */

    /* SSO 相关 */

    public static final String EMAIL_NONE_ACTIVED = "0"; //客户邮件未激活

    public static final String EMAIL_ACTIVED = "1"; //客户邮件已激活
    
    /* 性别类型，性别名称*/
	public static final String SEX_STATE_MALE = "1";

	public static final String SEX_STATE_FEMALE = "0";

	public static final String SEX_TITLE_GENTLEMAN = "先生";

	public static final String SEX_TITLE_LADY = "女士";

    /* SSO 相关结束 */
    
    /**默认显示第一页内容。用于初次进入页面时使用*/
    public static final int PAGE_DEFAULT_NUMBER = 1;
    /**商铺风格cookie名称*/
    public static final String COOKIE_NAME_SHOP_STYLE = "skin";
    /**商铺导航位置cookie名称*/
    public static final String COOKIE_NAME_SHOP_BAR_LOCATION = "shop_bar_location";
    /**商铺首页排序cookie名称*/
    public static final String COOKIE_NAME_SHOP_INDEX_ORDER = "shop_index_order";
    /**商铺友情链接cookie名称*/
    public static final String COOKIE_NAME_SHOP_FRIENDLINK = "shop_friendlink";
    /**拥有者首次访问商铺友情链接写cookie名称*/
    public static final String COOKIE_NAME_VISIT_SHOP_FRIENDLINK = "shop_friendlink_first";
    /**商铺cookie默认存活期*/
    public static final int COOKIE_EXPIRES_SHOP_DEFAULT = 60*30;
    /**管理友情链接返回接口分隔符*/
    public static final String SHOP_LINK_SPLIT_STR = "!~!";
    /**友情链接cookie分隔符*/
    public static final String SHOP_LINK_COOKIE_SPLIT_STR = "Ea39Iwo0oP";
    
    /**商铺SEO公司简介长度*/
    public static final int SEO_DETAI_CORP_INTRODUCE_LENGTH = 80;
    /**商铺SEO主营销售产品最大个数*/
    public static final int SEO_DETAI_MAINPRO_MAX_NUM = 3;
    /**商铺SEO主营销售产品关健词最大长度*/
    public static final int SEO_DETAI_MAINPRO_LENGTH = 10;
    /**商铺SEO主营销售产品关健词默认分隔符*/
    public static final String SEO_DETAI_MAINPRO_SPLIT_SIGN = ",";
    /**商铺SEO省略符*/
    public static final String SEO_DETAI_OMIT = "...";
    
    /** 终极页类型定义开始 */   
    /**企业终极页面构造类型*/
    public static final String PAGE_INFOTYPE_HOMEPAGE = "5";
    /**公司介绍终极页面构造类型*/
    public static final String PAGE_INFOTYPE_INTRODUCE = "6";
    /**总裁访谈终极页面构造类型*/
    public static final String PAGE_INFOTYPE_VIP_VISIT = "7";
    /**公司动态终极页面构造类型*/
    public static final String PAGE_INFOTYPE_INFO = "8";
    /**买卖通档案终极页面构造类型*/
    public static final String PAGE_INFOTYPE_MMT_DOCS = "9";
    /**CA及电子签章终极页面构造类型*/
    public static final String PAGE_INFOTYPE_CA_CREDIT = "10";   
    /**资信参考人终极页面构造类型*/
    public static final String PAGE_INFOTYPE_CREDIT_INDICATER = "11";
    /**客户评价终极页面构造类型*/
    public static final String PAGE_INFOTYPE_MEMBER_VA = "12";
    /**证书荣誉终极页面构造类型*/
    public static final String PAGE_INFOTYPE_CREDIT = "13";
    /**市场活动记录终极页面构造类型*/
    public static final String PAGE_INFOTYPE_MARKET_TRACE = "14";
    /**招聘中心终极页面构造类型*/
    public static final String PAGE_INFOTYPE_JOB = "15";
    /**联系信息终极页面构造类型*/
    public static final String PAGE_INFOTYPE_COMPANY = "17";
    /**网络名片页面构造类型*/
    public static final String PAGE_INFOTYPE_CARD="20";
    /**产品展示-橱窗终极页面构造类型*/
    public static final String PAGE_INFOTYPE_PRODUCT_WINDOW = "27";
    /**供应信息-橱窗终极页面构造类型*/
    public static final String PAGE_INFOTYPE_BUSIN_WINDOW = "29";
    /**采购清单-列表终极页面构造类型*/
    public static final String PAGE_INFOTYPE_BUSIN_BUY = "30";
    /**采购清单-橱窗终极页面构造类型*/
    public static final String PAGE_INFOTYPE_BUSIN_BUY_WINDOW = "31";
    /**采购专场终极页面构造类型*/
    public static final String PAGE_INFOTYPE_BUY_MARKET = "32";
    /**商图终极页面构造类型*/
    public static final String PAGE_INFOTYPE_BIZ_FRIEND = "35";
    /**留言终极页构造类型*/
    public static final String PAGE_BUSNOTE = "37"; 
    /**私密展厅橱窗页*/
    public static final String PAGE_PRIVATE_PRODUCT = "39";
    /**公司相册列表页*/
    public static final String PAGE_ALBUM = "46";
    /**业内新闻*/
    public static final String PAGE_AREA_NEWS = "47";
    /**图片所属像册播放页*/
    public static final String  PAGE_ALBUM_SHOW = "48";
    /**用户自定义频道*/
    public static final String PAGE_CUSTOM_CHANNEL = "49";
    /**业内资讯列表页频道*/
    public static final String PAGE_COLUMN_NEWS = "50";
    /**证书终极页地址*/
    public static final String PAGE_CREDIT_DETAIL="51";
    /**获取在线客服列表的ajax地址*/
    public static final String AJAX_ONLINESERVICES="52";
    /**慧聪实地拍摄地址*/
    public static final String PAGE_INFOTYPE_REALPHOTO="53";
    /** 终极页类型定义结束 */
    
    /** style类型定义开始 */
    /** 系统类型标示 */
    public static final String DETAIL_SYS_FLAG ="1";

    /** 文件类型标示*/
    public static final String FILE_TYPE_IMAGE_COLOR="1";
    public static final String FILE_TYPE_IMAGE_BW="2";
    public static final String FILE_TYPE_CSS="3";
    
    /** 模块标示*/
    public static final int PUBLIC_MODEL_FLAG =0;
    /**商铺高级主题类型*/
    public static final String STYLE_TYPE_AD_TOPIC = "0";
    /** style类型定义结束 */

    /** 招聘职位信息 可接收的求职申请的最大数量 1000 */
    public static final long HR_JOBAPP_REC_MAX=1000;
    
    
    /**搜索接口定义*/
    /**提取搜索推荐关键字数据接口w=关键字&type=1&subtype=1*/
    public static final String SEARCH_RECOMMEND_WORD="http://s.hc360.com/cgi-bin/checkword?";
    
    public static final String SEARCH_TD1_URI="http://s.hc360.com/cgi-bin/td1?";
    
	
	//缓存中配置记录的key
	public static final String INTENTION_CONFIG_MEM_ID = "00001";
	//商机分类在线交易配置bean 在缓存的key
	public static final String BUSIN_CAT_CONFIG_MEMCACHE_KEY = "busin_cat_config_memcache_key";

}
