/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    
    Queue<Integer> que = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        if(nestedList != null && nestedList.size() != 0) {
            pushListToQueue(nestedList);
        }
    }
    
    public void pushListToQueue(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return;
        }
        for(NestedInteger i : nestedList) {
            if(i.isInteger()) {
                que.offer(i.getInteger());
            } else {
                pushListToQueue(i.getList());
            }
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        if(!hasNext()) {
            return null;
        }
        return que.poll();
        // Write your code here
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        return !que.isEmpty();
        // Write your code here
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */
