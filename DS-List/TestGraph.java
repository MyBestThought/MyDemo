package com.graphs;

class Graph{
    char[] vexs = null;
    int vexNum;
    int edgeNum;
    int[][] matrix = null;

    public Graph(){}

    public Graph(int size){
        vexs = new char[size];
        matrix = new int[size][size];
    }
}

class Edge{
    char start;
    char end;
    int weight;

}

public class TestGraph{

    public static void main(String[] args) {
        char a[]={'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I'};
        int[][] b={
                {'A', 'B',6},
                {'A', 'C',4},
                {'A', 'D',5},
                {'B', 'E',1},
                {'C', 'E',1},
                {'D', 'F',2},
                {'E', 'G',9},
                {'E', 'H',7},
                {'F', 'H',4},
                {'G', 'I',2},
                {'H', 'I',4}};

        TestGraph testGraph = new TestGraph();
        Graph g = testGraph.createGraph(a, b, a.length, b.length);
        for (int i = 0; i < g.matrix.length; i++) {
            for (int j = 0; j < g.matrix[i].length; j++) {
                System.out.print(g.matrix[i][j] + "\t");
            }
            System.out.println();
        }
        testGraph.getKeyPath(g);
    }

    public void getKeyPath(Graph g){
        int[] a = new int[g.vexNum];
        int[] b = new int[g.vexNum];
        int[] c = new int[g.vexNum];
        for (int i = 0; i < g.vexNum; i++) {
            int max = 0;
            for (int j = 0; j < g.vexNum; j++) {
                if(g.matrix[j][i] > 0 && a[j] + g.matrix[j][i] > max){
                    max = g.matrix[j][i] + a[j];
                    a[i] = max;

                }
            }
        }
        System.out.println("第一个结点到最后一个结点的路径和长度为:");
        for (int i = 0; i < g.vexs.length; i++) {
            System.out.print(g.vexs[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < g.vexNum; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
        System.out.println("最后一个结点到第一个结点的路径和长度为:");
        for(int i = g.vexNum-1; i >=0; i--){
            int max = 0;
            for (int j = g.vexNum-1; j >= 0; j--) {
                if(g.matrix[i][j] > 0 && b[j] + g.matrix[i][j] > max){
                    max = g.matrix[i][j] + b[j];
                    b[i] = max;
                }
            }
        }
        for (int i = 0; i < g.vexs.length; i++) {
            System.out.print(g.vexs[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < g.vexNum; i++) {
            System.out.print(b[i] + "\t");
        }
        System.out.println();
        System.out.println("关键路径为: ");
        for (int i = 0; i < g.vexNum; i++) {
            if(a[i] == a[g.vexNum-1] - b[i]){
                System.out.print(g.vexs[i] + "\t");
            }
        }

    }


    public Graph createGraph(char[] a, int[][] b, int vertxNum, int edgeNum){
        Graph g = new Graph(a.length);
        g.vexNum = vertxNum;
        g.edgeNum = edgeNum;
        for (int i = 0; i < vertxNum; i++) {
            g.vexs[i] = a[i];
        }
        for (int i = 0; i < g.edgeNum; i++) {
            int p1= 0, p2 = 0;
            char c1 = (char)b[i][0];
            char c2 = (char)b[i][1];
            p1 = pointNode(g, c1);
            p2 = pointNode(g, c2);
            if(p1 == -1 || p2 == -1){
                System.out.println("invalid edge ");
                continue;
            }
            g.matrix[p1][p2] = b[i][2];
        }
        return g;
    }

    public int pointNode(Graph g, char c){
        for (int i = 0; i < g.vexNum; i++) {
            if(g.vexs[i] == c){
                return i;
            }
        }
        return -1;
    }
}