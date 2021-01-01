function pageAdd(num) {
    location='VoteListServlet?num=' + (num+1);
}

function pageReduce(num) {
    location='VoteListServlet?num=' + (num-1);
}