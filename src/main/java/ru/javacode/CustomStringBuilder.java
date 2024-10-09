package ru.javacode;

import ru.javacode.snapshot.StringSnapshot;

import java.io.*;
import java.util.Stack;

public class CustomStringBuilder{
    private StringBuilder value;
    private Stack<StringSnapshot> stackSnapshots = new Stack<>();

    public CustomStringBuilder() {
        value = new StringBuilder();
    }

    public CustomStringBuilder(int capacity) {
        value = new StringBuilder(capacity);
    }

    public CustomStringBuilder(String str) {
        value = new StringBuilder(str);
    }

    public CustomStringBuilder(CharSequence seq) {
        value = new StringBuilder(seq);
    }

    public int compareTo(CustomStringBuilder another) {
        return value.compareTo(another.getStringBuilder());
    }

    public CustomStringBuilder append(Object obj) {
        saveState();
        return append(String.valueOf(obj));
    }

    public CustomStringBuilder append(String str) {
        saveState();
        value.append(str);
        return this;
    }

    public CustomStringBuilder append(StringBuffer sb) {
        saveState();
        value.append(sb);
        return this;
    }

    public CustomStringBuilder append(CharSequence s) {
        saveState();
        value.append(s);
        return this;
    }

    public CustomStringBuilder append(CharSequence s, int start, int end) {
        saveState();
        value.append(s, start, end);
        return this;
    }

    public CustomStringBuilder append(char[] str) {
        saveState();
        value.append(str);
        return this;
    }

    public CustomStringBuilder append(char[] str, int offset, int len) {
        saveState();
        value.append(str, offset, len);
        return this;
    }

    public CustomStringBuilder append(boolean b) {
        saveState();
        value.append(b);
        return this;
    }

    public CustomStringBuilder append(char c) {
        saveState();
        value.append(c);
        return this;
    }

    public CustomStringBuilder append(int i) {
        saveState();
        value.append(i);
        return this;
    }

    public CustomStringBuilder append(long lng) {
        saveState();
        value.append(lng);
        return this;
    }

    public CustomStringBuilder append(float f) {
        saveState();
        value.append(f);
        return this;
    }

    public CustomStringBuilder append(double d) {
        saveState();
        value.append(d);
        return this;
    }

    public CustomStringBuilder appendCodePoint(int codePoint) {
        saveState();
        value.appendCodePoint(codePoint);
        return this;
    }

    public CustomStringBuilder delete(int start, int end) {
        saveState();
        value.delete(start, end);
        return this;
    }

    public CustomStringBuilder deleteCharAt(int index) {
        saveState();
        value.deleteCharAt(index);
        return this;
    }

    public CustomStringBuilder replace(int start, int end, String str) {
        saveState();
        value.replace(start, end, str);
        return this;
    }

    public CustomStringBuilder insert(int index, char[] str, int offset,
                                int len)
    {
        saveState();
        value.insert(index, str, offset, len);
        return this;
    }

    public CustomStringBuilder insert(int offset, Object obj) {
        saveState();
        value.insert(offset, obj);
        return this;
    }

    public CustomStringBuilder insert(int offset, String str) {
        saveState();
        value.insert(offset, str);
        return this;
    }

    public CustomStringBuilder insert(int offset, char[] str) {
        saveState();
        value.insert(offset, str);
        return this;
    }

    public CustomStringBuilder insert(int dstOffset, CharSequence s) {
        saveState();
        value.insert(dstOffset, s);
        return this;
    }

    public CustomStringBuilder insert(int dstOffset, CharSequence s,
                                int start, int end)
    {
        saveState();
        value.insert(dstOffset, s, start, end);
        return this;
    }

    public CustomStringBuilder insert(int offset, boolean b) {
        saveState();
        value.insert(offset, b);
        return this;
    }

    public CustomStringBuilder insert(int offset, char c) {
        saveState();
        value.insert(offset, c);
        return this;
    }

    public CustomStringBuilder insert(int offset, int i) {
        saveState();
        value.insert(offset, i);
        return this;
    }

    public CustomStringBuilder insert(int offset, long l) {
        saveState();
        value.insert(offset, l);
        return this;
    }

    public CustomStringBuilder insert(int offset, float f) {
        saveState();
        value.insert(offset, f);
        return this;
    }

    public CustomStringBuilder insert(int offset, double d) {
        saveState();
        value.insert(offset, d);
        return this;
    }

    public int indexOf(String str) {
        return value.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return value.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str) {
        return value.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return value.lastIndexOf(str, fromIndex);
    }

    public CustomStringBuilder reverse() {
        saveState();
        value.reverse();
        return this;
    }

    public CustomStringBuilder repeat(CharSequence cs, int count) {
        saveState();
        value.repeat(cs, count);
        return this;
    }

    public String toString() {
        return new String(this.value);
    }

    public StringBuilder getStringBuilder(){
        return value;
    }

    public void undo(){
        if(!stackSnapshots.isEmpty()){
            value.setLength(0);
            value.append(stackSnapshots.peek().getState());
        }else{
            System.err.println("Stack is empty");
        }
    }

    private void saveState(){
        stackSnapshots.push(new StringSnapshot(value.toString()));
    }
}