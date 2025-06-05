package ru.iFellow.dto.CharacterModels;
import lombok.Data;

@Data
public class Info{
    public int count;
    public int pages;
    public Object next;
    public Object prev;
}