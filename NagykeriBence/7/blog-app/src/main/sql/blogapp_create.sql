CREATE SEQUENCE public."Bloggers_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Bloggers_id_seq"
  OWNER TO postgres;

CREATE SEQUENCE public."BlogPosts_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."BlogPosts_id_seq"
  OWNER TO postgres;

CREATE SEQUENCE public."Comments_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Comments_id_seq"
  OWNER TO postgres;

CREATE TABLE public."Bloggers"(
                bloggerID integer NOT NULL PRIMARY KEY DEFAULT nextval('"Bloggers_id_seq"'::regclass),
                firstName varchar,
                lastName varchar,
                nickName varchar UNIQUE,
                age integer
);

CREATE TABLE public."BlogPosts"(
                postID integer NOT NULL PRIMARY KEY DEFAULT nextval('"Comments_id_seq"'::regclass),
                time timestamp,
                title varchar,
                message varchar,
                bloggerID integer REFERENCES public."Bloggers"(bloggerID)
);
CREATE TABLE public."Comments"(
                commentID integer NOT NULL PRIMARY KEY DEFAULT nextval('"BlogPosts_id_seq"'::regclass),
                commenter varchar,
                content varchar,
				time timestamp,
                blogPostID integer REFERENCES public."BlogPosts"(postID)
);