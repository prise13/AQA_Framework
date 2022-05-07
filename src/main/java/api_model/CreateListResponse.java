package api_model;

import java.util.Objects;

public class CreateListResponse {
    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Object pos;
    private Object limits;

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

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateListResponse that = (CreateListResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(closed, that.closed) && Objects.equals(idBoard, that.idBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, closed, idBoard);
    }
}
