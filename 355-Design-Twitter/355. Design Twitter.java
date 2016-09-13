public class Twitter {
    // 参考博文: http://blog.csdn.net/u013027996/article/details/51671450
	private Map<Integer, List<Integer>> followMap;
    private Map<Integer, List<Integer>> tweetMap;
    private List<Integer> tweetList;

    /**
     * Initialize your data structure here.
     */
    public Twitter() 
    {
        followMap = new HashMap<Integer, List<Integer>>();
        tweetMap = new HashMap<Integer, List<Integer>>();
        tweetList = new ArrayList<Integer>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) 
    {
        List<Integer> list = new ArrayList<Integer>();
        // 这个用户已经有推送过tweet了
        if(tweetMap.containsKey(userId))
            list = tweetMap.get(userId);
        // 把当前的tweet加入表中
        list.add(tweetId);
        tweetMap.put(userId, list);
        tweetList.add(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) 
    {
        // 先获得用户自己发送的twitter
        List<Integer> list = new ArrayList<Integer>();
        if(tweetMap.containsKey(userId))
            list = tweetMap.get(userId);
        
        // 再获得收听的用户所有的twitter
        List<Integer> allList = new ArrayList<Integer>(list);
        List<Integer> followees = new ArrayList<Integer>();
        // 得到当前用户收听的所有用户的ID
        if(followMap.containsKey(userId))
            followees = followMap.get(userId);
        // 每个被收听的用户
        for(int i = 0; i < followees.size(); i++)
            // 获得每个被收听用户发送的twitter并加入allList里
            if(tweetMap.containsKey(followees.get(i)))
                allList.addAll(tweetMap.get(followees.get(i)));
        
        // 最后生成需要返回的前十条twitter
        // 把allList转成哈希表减少查找的时间复杂度
        Set<Integer> set = new HashSet<Integer>(allList);
        List<Integer> feedList = new ArrayList<Integer>();
        int k = 0;
        // 因为越晚发的twitter在用add函数加入时在越后面，所以从后往前找最近发送的十个
        // tweetList是所有发过的twitter的队列，我们从最后开始找，只要twitter出现在allList中就是一个符合条件的twitter
        for(int i = tweetList.size() - 1; i >= 0; i--) 
        {
            if(k == 10)
                break;
            // 得到twitter的ID
            int tweetId = tweetList.get(i);
            // 这个ID在当前用户自己发的或是收听的用户发的则加入feedList
            if(set.contains(tweetId)) 
            {
                feedList.add(tweetId);
                k++;
            }
        }
        return feedList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) 
    {
        List<Integer> list = new ArrayList<Integer>();
        // 当前用户已经收听过其他用户了
        if(followMap.containsKey(followerId))
            list = followMap.get(followerId);
        
        // 当前用户followerId还没有收听过用户followeeId
        if(!list.contains(followeeId))
            list.add(followeeId);
        followMap.put(followerId, list);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) 
    {
        // 当前用户followerId收听过了用户followeeId
        if(followMap.containsKey(followerId)) 
        {
            // 获取当前用户收听的用户队列
            List<Integer> list = followMap.get(followerId);
            // 从队列中删除用户followeeId
            list.remove((Integer) followeeId);
            followMap.put(followerId, list);
        }
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