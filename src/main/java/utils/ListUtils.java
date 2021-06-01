package utils;


import java.util.List;

public class ListUtils<E> {

    public Boolean isNotEmpty(List<E> list){
        return !list.isEmpty() && list != null;
    }
}
