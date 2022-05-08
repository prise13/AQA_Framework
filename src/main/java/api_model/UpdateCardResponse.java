package api_model;

import java.util.Objects;

public class UpdateCardResponse {
    String id;
    Boolean closed;
    String idBoard;
    String idList;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCardResponse that = (UpdateCardResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(closed, that.closed) && Objects.equals(idBoard, that.idBoard) && Objects.equals(idList, that.idList) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, closed, idBoard, idList, name);
    }
}
