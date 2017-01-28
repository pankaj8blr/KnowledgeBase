
CREATE TABLE topic
(
  topic_id integer NOT NULL,
  topic_name character varying(255),
  CONSTRAINT topic_pkey PRIMARY KEY (topic_id)
);

INSERT INTO topic(
            topic_id, topic_name)
    VALUES (1, 'Entertainment');
INSERT INTO topic(
            topic_id, topic_name)
    VALUES (2, 'Sports');
INSERT INTO topic(
            topic_id, topic_name)
    VALUES (3, 'Technology');

commit;