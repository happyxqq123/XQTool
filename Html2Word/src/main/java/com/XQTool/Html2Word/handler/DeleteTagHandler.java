package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 * 删除线
 * @author xuwangcheng
 * @version 1.0.0
 * @description
 * @date 2021/12/9 9:24
 */
public class DeleteTagHandler extends BaseHtmlTagHandler {

    @Override
    public String getMatchTagName() {
        return "s|del|strike";
    }

    @Override
    public void handleHtmlElement(HandlerParams params, Style style) {
        style.setStrike(true);
    }
}
