package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedAndItalicAndBoldHtmlText extends HtmlText {
    public UnderlinedAndItalicAndBoldHtmlText(String text) {
        super("<u><i><b>"+text+"</b></i></u>");
    }
}
