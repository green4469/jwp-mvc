package nextstep.mvc.tobe;

public class UnsupportedViewException extends RuntimeException {
    public static final String UNSUPPORTED_VIEW_MESSAGE = "지원하지 않는 뷰 입니다.";

    public UnsupportedViewException() {
        super(UNSUPPORTED_VIEW_MESSAGE);
    }
}
