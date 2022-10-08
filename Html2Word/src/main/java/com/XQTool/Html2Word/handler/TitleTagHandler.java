package com.XQTool.Html2Word.handler;

import cn.hutool.core.util.ReUtil;
import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;
import org.jsoup.nodes.Element;

/**
 * 标题
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/12/8 14:51
 */
public class TitleTagHandler extends BaseHtmlTagHandler {

    private static final int MAX_TITLE_FONT_SIZE = 28;

    @Override
    public String getMatchTagName() {
        return "h[123456]";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        if (params.isEnableBreak()) {
            params.getCurrentRun().addBreak();
            params.setEnableBreak(false);
        }
        Element element = (Element) params.getCurrentNode();
        style.setBold(true);
        style.setFontSize(MAX_TITLE_FONT_SIZE - (ReUtil.getFirstNumber(element.tagName()) - 1) * 2);
    }
}
