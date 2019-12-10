package com.example.reposlisting;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.reposlisting.data.Repo;
import com.example.reposlisting.data.RepoDao;
import com.example.reposlisting.data.RepoDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

public class RepoDaoTest {


    private RepoDatabase repoDatabase;
    private RepoDao repoDao;

    @Before
    public void initDB() {
        repoDatabase = Room
                .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), RepoDatabase.class)
                .allowMainThreadQueries()
                .build();
        repoDao = repoDatabase.repoDao();

    }

    @Test
    public void insertAndLoad() throws InterruptedException {

        List<Repo> testRepos = RepoDataProvider.initTestData();

        BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getMain(), CoroutineStart.DEFAULT, (coroutineScope, continuation) -> repoDao.insertAll(testRepos, continuation));

        List<Repo> repos = LiveDataTestUtil.getValue(repoDao.loadAllRepos());

        assertThat(repos.size(),is (testRepos.size()));

        Repo repo1 = LiveDataTestUtil.getValue(repoDao.loadRepo(1));

        assertThat(repo1.getName(), is (RepoDataProvider.repo1.getName()));

        RepoDataProvider.repo4.setBookmarked(true);

        BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getMain(), CoroutineStart.DEFAULT, (coroutineScope, continuation) -> repoDao.updateRepo(RepoDataProvider.repo4, continuation));

        assertThat(RepoDataProvider.repo4.isBookmarked(), is(true));

    }

    @After
    public void closeDB() {
        repoDatabase.close();
    }
}
