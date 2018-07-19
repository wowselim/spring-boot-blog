package co.selim.blog.model;

import java.time.LocalDate;

public class BlogPost {
    private final String title;
    private final String text;
    private final LocalDate date;

    private BlogPost(String title, String text, LocalDate date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }

    public static final class BlogPostBuilder {
        private String title;
        private String text;
        private LocalDate date;

        private BlogPostBuilder() {
        }

        public static BlogPostBuilder aBlogPost() {
            return new BlogPostBuilder();
        }

        public BlogPostBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BlogPostBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public BlogPostBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public BlogPost build() {
            return new BlogPost(title, text, date);
        }
    }
}
