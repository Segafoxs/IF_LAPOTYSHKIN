package ru.iFellow.dto.CharacterModels;
import lombok.Data;
import java.util.ArrayList;

@Data
public class Root{
    public Info info;
    public ArrayList<Character> results;
}