class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
        int n = prerequisites.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < n; i++) {
            indegree[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int count=0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                count++; // this will get the count of all the cources that are independent
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children!=null){
                for(int child: children){
                indegree[child]--;
                if(indegree[child]==0){
                    q.add(child);
                    count++;
                    if(count==numCourses) return true;
                }
            }
            }
            
        }
        if(count==numCourses) return true;
        return false;

    }
    //Logic
    //topological sort
    //At any point of when the dependency is getting 0 process it.
    //Any point there is a cycle then we need to return false.
}