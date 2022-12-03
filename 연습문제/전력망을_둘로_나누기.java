package 연습문제;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 전력망을_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        Map<Integer, Node> map = new HashMap<>();
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            Node nodeA = map.containsKey(a) ? map.get(a) : new Node(a);
            Node nodeB = map.containsKey(b) ? map.get(b) : new Node(b);
            nodeA.linkedNode.add(nodeB);
            nodeB.linkedNode.add(nodeA);
            map.put(a, nodeA);
            map.put(b, nodeB);

        }
        boolean[] visited = new boolean[n+1];
        Integer[] result = new Integer[1];
        result[0] = n;
        cal(n, map, 1, visited, result);
        return result[0];
    }
    public int cal(int n, Map<Integer, Node> nodeMap, int index, boolean[] visited, Integer[] result){
        if(visited[index]) return 0; // 이전 방문 기록 시 return;
        visited[index] = true;

        List<Node> linkedNodes = nodeMap.get(index).linkedNode;
        int sum = 1;
        for(Node linkedNode : linkedNodes){
            int linkedNodeCnt = cal(n, nodeMap, linkedNode.number, visited, result);
            sum += linkedNodeCnt;
        }
        result[0] = Math.min(result[0],Math.abs(sum - (n-sum)));
        return sum;
    }

    class Node {
        int number;
        List<Node> linkedNode;
        public Node(int i){
            number = i;
            linkedNode = new ArrayList<>();
        }
    }
}
