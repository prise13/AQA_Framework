package api_model;

public class GetBoardListsResponse {
    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Object pos;
    private Boolean subscribed;
    private Object softLimit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public Object getPos() {
        return pos;
    }

    public void setPos(Object pos) {
        this.pos = pos;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Object getSoftLimit() {
        return softLimit;
    }

    public void setSoftLimit(Object softLimit) {
        this.softLimit = softLimit;
    }
}
