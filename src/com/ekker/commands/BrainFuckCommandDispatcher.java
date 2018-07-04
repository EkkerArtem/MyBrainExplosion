package com.ekker.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Artem on 8/3/2018.
 */
public class BrainFuckCommandDispatcher {

    public static final Character INCREMENT = '+';
    public static final Character DECREMENT = '-';
    public static final Character CLOSING_BRACKET = ']';
    public static final Character OPENING_BRACKET = '[';
    public static final Character MOVE_LEFT = '<';
    public static final Character MOVE_RIGHT = '>';
    public static final Character OUTPUT = '.';

    private Map<Character, BrainFuckCommand> commands;

    public BrainFuckCommandDispatcher() {
        commands = new HashMap<>();
        commands.put(INCREMENT, new IncrementCurrentValue());
        commands.put(DECREMENT, new DecrementCurrentValue());
        commands.put(OPENING_BRACKET, new OpeningSquareBracket());
        commands.put(CLOSING_BRACKET, new ClosingSquareBracket());
        commands.put(MOVE_RIGHT, new MoveRight());
        commands.put(MOVE_LEFT, new MoveLeft());
        commands.put(OUTPUT, new OutputCurrentCharacter());
    }

    public BrainFuckCommand getCommand(Character command) {
        return commands.get(command);
    }
}
