package org.learning.javapractice.sudoku;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Value {
    List<Integer> options;
    Integer value;
}
