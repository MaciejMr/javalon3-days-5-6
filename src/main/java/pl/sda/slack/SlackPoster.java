package pl.sda.slack;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.model.block.ImageBlock;
import com.github.seratch.jslack.api.model.block.SectionBlock;
import com.github.seratch.jslack.api.model.block.composition.PlainTextObject;
import com.github.seratch.jslack.api.webhook.Payload;

import java.util.List;

public class SlackPoster {

    public static void main(String[] args) {
        try {
            new SlackPoster().post();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void post() throws Exception {
        Payload build = Payload.builder()
                .blocks(
                        List.of(
                                SectionBlock.builder()
                                        .text(PlainTextObject.builder().text("Testuje").build())
                                        .build(),
                                ImageBlock.builder()
                                        .imageUrl("https://www.rd.com/wp-content/uploads/2019/11/cat-10-e1573844975155-1024x692.jpg")
                                        .altText("To je kot")
                                        .build()
                        )
                ).build();
        Slack instance = Slack.getInstance();
        String url = ""; //channel url
        instance.send(url, build);
        instance.close();
    }

}
