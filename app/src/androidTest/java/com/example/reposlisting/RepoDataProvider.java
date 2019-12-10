package com.example.reposlisting;

import com.example.reposlisting.data.Repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepoDataProvider {

    static  Repo repo1,repo2,repo3,repo4;

    public static List<Repo> initTestData(){


        repo1 = new Repo();
        repo1.setId(1);
        repo1.setName("Repo1");
        repo1.setDescription("Repo1   Repo1");
        repo1.setStarsCount(4);
        repo1.setBookmarked(false);

        repo2 = new Repo();
        repo2.setId(2);
        repo2.setName("Repo2");
        repo2.setDescription("Repo2   Repo2");
        repo2.setStarsCount(5);
        repo2.setBookmarked(true);

        repo3 = new Repo();
        repo3.setId(3);
        repo3.setName("Repo3");
        repo3.setDescription("Repo3   Repo3");
        repo3.setStarsCount(6);
        repo3.setBookmarked(false);

        repo4 = new Repo();
        repo4.setId(4);
        repo4.setName("Repo4");
        repo4.setDescription("Repo4   Repo4");
        repo4.setStarsCount(7);
        repo4.setBookmarked(false);

        return Arrays.asList(repo1,repo2,repo3,repo4);

    }
}
