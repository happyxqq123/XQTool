package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2022/3/1 11:28
 */
public class ThTagHandler extends BaseHtmlTagHandler {
    @Override
    public String getMatchTagName() {
        return "th";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
       // style.setUnderLine(true);
    }
}
