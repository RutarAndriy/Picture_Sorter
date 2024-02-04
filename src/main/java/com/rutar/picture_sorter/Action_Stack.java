package com.rutar.picture_sorter;

import java.util.*;

// ............................................................................

/**
 * Клас реалізує стек дій
 * @author RutarAndriy
 * 04.02.2024
 */

public class Action_Stack {

///////////////////////////////////////////////////////////////////////////////

/** Перелік доступних дій із файлами */
public static enum ACTIONS {
    
    /** Переміщення */
    MOVE,
    /** Копіювання */
    COPY,
    /** Переміщення в корзину */
    TRASH,
    /** Видалення */
    DELETE

}

// ............................................................................

private final Stack action_stack = new Stack();

///////////////////////////////////////////////////////////////////////////////

/**
 * Додавання нової дії в стек
 * @param action тип дії (MOVE, COPY, TRASH або DELETE)
 * @param source вхідний файл
 * @param result вихідний файл
 */
public void push (ACTIONS action, String source, String result) {

    Action new_action = new Action(action, source, result);
    
    action_stack.push(new_action);

}

///////////////////////////////////////////////////////////////////////////////

/**
 * Видалення останього елементу стеку
 * @return останній елемент стеку
 */
public Action pop() { return (Action) action_stack.pop(); }

///////////////////////////////////////////////////////////////////////////////

/**
 * Отримання останього елемента стеку
 * @return останній елемент стеку
 */
public Action peek() { return (Action) action_stack.peek(); }

///////////////////////////////////////////////////////////////////////////////

/**
 * Клас описує параметри дії
 * @author RutarAndriy
 * 04.02.2024
 */

public class Action {
    
/** Тип дії (MOVE, COPY, TRASH або DELETE) */
public ACTIONS action;

/** Вхідний файл */
public String source;

/** Вихідний файл */
public String result;

///////////////////////////////////////////////////////////////////////////////

/**
 * Конструктор класу Action
 * @param action тип дії (MOVE, COPY, TRASH або DELETE)
 * @param source вхідний файл
 * @param result вихідний файл
 */
public Action (ACTIONS action, String source, String result) {
            
    this.action = action;
    this.source = source;
    this.result = result;

}

// Кінець класу Action ////////////////////////////////////////////////////////
    
}

// Кінець класу Action_Stack //////////////////////////////////////////////////

}
