package com.codecool.linkedlist;

public class SinglyLinkedList<T> {

    private class Link {

        private T value;
        private Link next;

        Link(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;
    public SinglyLinkedList() {
    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(T value) {
        Link new_node = new Link(value);
        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = null;
        Link last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;

    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public T get(int index) {
        int counter = 0;
        Link link=head;
        if(index == 0) {
            return head.getValue();
        }
        else if(index>0 && index<size()) {
            while (counter != index) {
                link = link.getNext();
                counter++;
            }
            return link.getValue();
        }
            throw new IndexOutOfBoundsException();
    }

    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */
    public int indexOf(T number) {
        int index = 0;
        Link current = head;

        while (current != null) {
            if (current.getValue().equals(number)) {
                return index;
            }
            index++;
            current = current.getNext();
        }

        return -1;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, T number) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();

        }else if(size()==0){
            add(number);
        }
        else if (index == 0 ) {
            Link newNode = new Link(number);
            newNode.setNext(head);
            head=newNode;
        }else if(index >0 &&index<size()){
            Link node = new Link(number);

            node.next = null;


            Link current = this.head;
            Link previous = null;

            int i = 0;

            while (i < index) {
                previous = current;
                current = current.next;

                if (current == null) {
                    break;
                }

                i++;
            }

            node.next = current;
            previous.next = node;
        }

        else if (index == size()) {
            add(number);
        }
    }
    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        if(head == null){
            return 0;
        }
        int counter = 1;
        Link current = head;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
