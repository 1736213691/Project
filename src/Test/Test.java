package Test;

import bean.UserVote;
import bean.Vote;
import utils.DBUtils;
import utils.UserUtils;
import utils.UserVoteUtils;
import utils.VoteUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int n = 1000;
        while(n++<1187){
            VoteUtils.deleteVote(n);
            Thread.sleep(10);
        }
    }
}