package dataframes.pageranking;

public class RankedPage {
    private int bodyContentLength;
    private int numberOfHeaders;
    private int numberOfLinks;
    private int page;
    private int position;
    private boolean queryInTitle;
    private int titleLength;
    private String url;

    public RankedPage() {
    }

    public RankedPage(int bodyContentLength, int numberOfHeaders, int numberOfLinks, int page, int position, boolean queryInTitle, int titleLength, String url) {
        this.bodyContentLength = bodyContentLength;
        this.numberOfHeaders = numberOfHeaders;
        this.numberOfLinks = numberOfLinks;
        this.page = page;
        this.position = position;
        this.queryInTitle = queryInTitle;
        this.titleLength = titleLength;
        this.url = url;
    }

    public int getBodyContentLength() {
        return bodyContentLength;
    }

    public void setBodyContentLength(int bodyContentLength) {
        this.bodyContentLength = bodyContentLength;
    }

    public int getNumberOfHeaders() {
        return numberOfHeaders;
    }

    public void setNumberOfHeaders(int numberOfHeaders) {
        this.numberOfHeaders = numberOfHeaders;
    }

    public int getNumberOfLinks() {
        return numberOfLinks;
    }

    public void setNumberOfLinks(int numberOfLinks) {
        this.numberOfLinks = numberOfLinks;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isQueryInTitle() {
        return queryInTitle;
    }

    public void setQueryInTitle(boolean queryInTitle) {
        this.queryInTitle = queryInTitle;
    }

    public int getTitleLength() {
        return titleLength;
    }

    public void setTitleLength(int titleLength) {
        this.titleLength = titleLength;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
