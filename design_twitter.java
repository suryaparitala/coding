public class Twitter {

    /** Initialize your data structure here. */
    
    int timestamp = 0;
    HashMap<Integer , User> userMap;
    
    private class Tweet{
        
        int tweetid;
        int time;
        public Tweet next;
        
        public Tweet(int tweetid){
            
            this.tweetid = tweetid;
            time = timestamp++;
            next = null;// tweets are arranges as linked list
            
            
        }
        
    }
    
    public class User{
        
        public int id;
        public HashSet<Integer> followed;
        public Tweet tweet_head;
        
        public User(int id){
            
            this.id = id;
            followed = new HashSet<Integer>();
            tweet_head = null;
            
            follow(id);// follow yourself to get your own tweets shown in your  newfeed    
        }
        
        
        public void follow(int id){// user class follow and unfollow methods
            
            followed.add(id);
            
            
        }
        
        public void unfollow(int id){
            
            followed.remove(id);
            
            
        }
        
        public void post(int tweetid){ // create a users tweets likes a list
            
            Tweet t = new Tweet(tweetid);
            t.next = tweet_head;
            tweet_head = t;
            
        }
        
        
        
        
    }
    public Twitter() {
        
        userMap = new HashMap<Integer,User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        
         if(!userMap.containsKey(userId)){// if a user is not there create one and post the tweet
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);// get the corresponing user object for the given id and call the post function
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {// use merge K sorted lists
        
        List<Integer> ans = new LinkedList<Integer>();
        
        if(!userMap.containsKey(userId)){
            return ans;
        }
        
        HashSet<Integer> followed = userMap.get(userId).followed;// get list of ppl  followed to update the tweets
        
       
        
        PriorityQueue<Tweet> que = new PriorityQueue<Tweet>(followed.size(), (a,b)->(b.time-a.time));// sort the queue accroding to decreaing order of timestamp as the one with big value is more recent, since only 10 tweets are needed we choose priority queue size to be 10
        
        
        for(int id : followed){
            
            Tweet t = userMap.get(id).tweet_head;
            if(t != null){
                que.add(t);
            }
        }
            
        //     int n=0;
        // while(!q.isEmpty() && n<10){
        //   Tweet t = q.poll();
        //   res.add(t.id);
        //   n++;
        //   if(t.next!=null)
        //     q.add(t.next);
        // }
            
            int n = 0;
            while(!que.isEmpty() && n < 10){
                
                Tweet temptweethead = que.poll();// pop the max timestamp tweet
                ans.add(temptweethead.tweetid);// add it to ans
                
                n++;
                if(temptweethead.next != null){// now move tweet head to next tweet and again add to queue
                    temptweethead = temptweethead.next;
                    que.add(temptweethead);
                }
                
                
                
            }
        
        return ans;
            
            
}
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
         if(!userMap.containsKey(followerId)){// create follower if he is not there in map
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){// create followe if he is no there in the map
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);// get the user object and to his list of follwers add the new guy
        
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
        if(!userMap.containsKey(followerId) || followerId==followeeId)// check if user is there if so then
            return;
        userMap.get(followerId).unfollow(followeeId);// get the corresponing user object and call unfollow function
    }
        
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */