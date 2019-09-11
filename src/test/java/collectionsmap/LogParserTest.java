package collectionsmap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LogParserTest {


    @Test
    public void entriesWithSameIpShouldBeInSameList() {
        // Given
        String log = "176.121.45.124:2016-12-02:derzsi\n"
                + "176.121.45.124:2016-12-03:ggrrrr\n";

        // When
        Map<String, List<Entry>> entries = new LogParser().parseLog(log);

        // Then
        assertThat(entries.size(), equalTo(1));
        assertThat(entries.get("176.121.45.124").size(), equalTo(2));
        assertThat(entries.get("176.121.45.124").get(0).getLogin(), equalTo("derzsi"));
        assertThat(entries.get("176.121.45.124").get(0).getIpAddress(), equalTo("176.121.45.124"));
        assertThat(entries.get("176.121.45.124").get(0).getEntryDate(), equalTo(LocalDate.of(2016, 12, 2)));
    }

    @Test
    public void entriesWithSameIpShouldBeInSameList2() {
        // Given
        String log = "176.121.45.124:2016-12-02:derzsi\n"
                + "176.121.45.124:2016-12-03:ggrrrr\n" 
		+ "175.121.45.124:2016-12-02:aaaa\n"
                + "175.121.45.124:2016-12-03:bbbb\n";

        // When
        Map<String, List<Entry>> entries = new LogParser().parseLog(log);

        // Then
        assertThat(entries.size(), equalTo(2));
        assertThat(entries.get("176.121.45.124").size(), equalTo(2));
	assertThat(entries.get("175.121.45.124").size(), equalTo(2));
    }

}
