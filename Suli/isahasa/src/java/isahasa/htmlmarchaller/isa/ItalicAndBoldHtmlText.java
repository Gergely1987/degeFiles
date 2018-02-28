package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class ItalicAndBoldHtmlText extends HtmlText {
    public ItalicAndBoldHtmlText(String text) {
        super("<i><b>"+text+"</b></i>");
    }
}
