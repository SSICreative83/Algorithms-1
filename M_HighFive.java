/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
class ScoreComparator implements Comparator<Record> {
    public int compare(Record r1, Record r2) {
        return r1.score - r2.score;
    }
}
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue> scoreMap = new HashMap<>();
        if(results == null || results.length == 0) {
            return res;
        }
        
        for(int i = 0; i < results.length; i++) {
            Record cur = results[i];
            if(scoreMap.containsKey(cur.id)) {
                PriorityQueue<Record> curQue = scoreMap.get(cur.id);
                if(curQue.size() < 5 ) {    //Need to do size check!
                    curQue.offer(cur);
                } else if(curQue.peek().score < cur.score){
                    curQue.poll();
                    curQue.offer(cur);
                }
                
            } else {
                PriorityQueue<Record> newQue = new PriorityQueue<Record>(5, new ScoreComparator());
                newQue.offer(cur);
                scoreMap.put(cur.id, newQue);
            }
        }
        
        for(int key : scoreMap.keySet()) {
            PriorityQueue<Record> curQue = scoreMap.get(key);
            double avg = 0.0;
            int size = curQue.size();
            while(!curQue.isEmpty()) {
                Record cur = curQue.poll();
                avg += cur.score;
            }
            avg = avg / size;
            res.put(key, avg);
        }
        return res;
    }
}
