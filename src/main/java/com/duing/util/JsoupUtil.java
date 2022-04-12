package com.duing.util;

import com.duing.entity.Chapter;
import com.duing.entity.ChapterContent;
import com.duing.service.ChapterContentService;
import com.duing.service.ChapterService;
import com.duing.util.vo.ChapterBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JsoupUtil {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private ChapterContentService chapterContentService;

    public static void main(String[] args) {
//        String html = "<html><head><title>First parse</title></head>\"\n" +
//                "  + \"<body><p>Parsed HTML into a doc.</p></body></html>";
//        Document document = Jsoup.parse(html);
//        System.out.println(document.title());
//        System.out.println(document.body());


        String str = "https://book.qidian.com/info/1021617576";

        String str2 = "https://book.qidian.com/info/1021617576/#Catalog";
    }

    /**
     *
     * @param urlStr  资源路径
     * @param bookId  书籍id
     */
    public void handler1(String urlStr, long bookId) {

//        List<String> resultList = new ArrayList<>();
        try {
            //根据资源路径获取文档资源
            Document doc = Jsoup.connect(urlStr).get();
            //通过css选择器解析文档 提取文档的章节名字 和 章节对应的链接
            List<ChapterBean> beans = parseBySelector(doc);
            //遍历beans （章节信息）
            for (ChapterBean bean : beans) {
                //通过章节链接获取本章节的内容
                String result = handler2(bean.getLink());
                //如果返回空字符串 表示需要vip才能看 直接结束本次循环
                if (result == "") return;

                //不需要vip身份就可以看 将内容保存至chapterContent中
                ChapterContent content = new ChapterContent();
                content.setContent(result);
                //将可看章节的内容保存到数据库中
                chapterContentService.save(content);
                long contentId = content.getId();

                //并保存章节信息
                Chapter chapter = new Chapter();
                chapter.setContentId(contentId);
                chapter.setBookId(bookId);
                chapter.setName(bean.getName());
//                resultList.add(result);
                chapterService.save(chapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过章节内容的链接 获取章节的内容：
     *       如果是本章节内容需要vip才能访问，则返回空字符串
     *       反之，则通过css选择器获取章节内容，并返回
     * @param urlStr 章节url
     * @return String 章节内容
     * @throws Exception
     */
    public String handler2(String urlStr) throws Exception {
//        String url = "https://read.qidian.com/chapter/O9zPuzOQBNt7DVpbqm07HA2/CR0cESE6Ba_M5j8_3RRvhw2/";
        //通过章节链接提取章节对应的文档
        Document document = Jsoup.connect(urlStr).get();

        //通过css选择器 提取出vip部分
        Elements vipEle = document.select("div.vip-limit-wrap");
        //判断是否是vip章节 如果vipEle长度>0 则是vip才能阅读 返回空字符串
        if (vipEle.size() > 0) {
            return "";
        }
        //如果无需vip就能访问 则通过css重新解析
        Element divEle = document.select("div.read-content.j_readContent").first();
        //返回章节的内容
        return divEle.text();
    }

    /**
     * 通过选择器解析文档  获取章节信息
     * @param doc  需要被解析的文档
     * @return 返回 List<ChapterBean>
     *              ChapterBean：
     *                  name：章节的名字
     *                  link：章节内容的链接
     */
    public List<ChapterBean> parseBySelector(Document doc) {
        //装载章节信息 章节名字 以及章节内容的链接
        List<ChapterBean> links = new ArrayList<>();
        // css选择器获取指定的元素
        Elements elements = doc.select("h2.book_name > a");
        for (Element h2Ele : elements) {
            //获取目标元素
            Element aEle = h2Ele.getElementsByTag("a").get(0);

            //存储目标元素所需的内容
            ChapterBean bean = new ChapterBean();
            bean.setLink("https:" + aEle.attr("href"));
            bean.setName(aEle.text());
            links.add(bean);
        }
        return links;
    }

    /**
     * 按照标签解析dom
     * @param doc 文档
     */
    public void parseByDom(Document doc) {
//            System.out.println(doc.title());
//            Element element = doc.getElementById("j-catalogWrap");

        Elements elements = doc.getElementsByTag("h2");
        System.out.println(elements.size());

        for (Element h2Ele : elements) {
            Element aEle = h2Ele.getElementsByTag("a").get(0);
            String linkHref = aEle.attr("href");
            String linkText = aEle.text();
            System.out.println(linkText + " 链接为 " + linkHref);
        }
    }

}
