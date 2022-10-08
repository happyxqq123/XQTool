package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * 下划线
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/12/9 9:19
 */
public class UnderlineTagHandler extends BaseHtmlTagHandler {


    @Override
    public String getMatchTagName() {
        return "u";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        //style.setUnderLine(true);
    }
}
