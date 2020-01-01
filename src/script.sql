create table student
(
    id        int auto_increment
        primary key,
    account   varchar(32)            not null,
    password  varchar(32)            not null,
    real_name varchar(32)            not null,
    sex       varchar(4) default '男' not null,
    constraint account
        unique (account)
);

create table subject
(
    id   int auto_increment
        primary key,
    name varchar(32) not null
);

create table teacher
(
    id        int auto_increment
        primary key,
    account   varchar(32)            not null,
    password  varchar(32)            not null,
    real_name varchar(32)            not null,
    sex       varchar(4) default '男' not null,
    constraint account
        unique (account)
);

create table class
(
    id         int auto_increment
        primary key,
    name       varchar(32) not null,
    class_code varchar(32) not null,
    tid        int         not null,
    constraint class_code
        unique (class_code),
    constraint class_ibfk_1
        foreign key (tid) references teacher (id)
);

create index tid
    on class (tid);

create table mid_class_student
(
    cid int not null,
    sid int not null,
    primary key (cid, sid),
    constraint mid_class_student_ibfk_1
        foreign key (cid) references class (id),
    constraint mid_class_student_ibfk_2
        foreign key (sid) references student (id)
);

create index sid
    on mid_class_student (sid);

create table question
(
    id        int auto_increment
        primary key,
    stem      text        not null,
    `explain` text        null,
    type      varchar(32) not null,
    sjid      int         not null,
    options   text        not null,
    answers   text        not null,
    tid       int         null,
    constraint question_ibfk_1
        foreign key (sjid) references subject (id),
    constraint question_ibfk_2
        foreign key (tid) references teacher (id)
);

create index sjid
    on question (sjid);

create index tid
    on question (tid);

create table question_bank
(
    id   int auto_increment
        primary key,
    name varchar(32) not null,
    type varchar(32) not null,
    tid  int         null,
    sjid int         not null,
    constraint question_bank_ibfk_1
        foreign key (sjid) references subject (id),
    constraint question_bank_ibfk_2
        foreign key (tid) references teacher (id)
);

create table mid_qbank_question
(
    qbid int not null,
    qid  int not null,
    primary key (qbid, qid),
    constraint mid_qbank_question_ibfk_1
        foreign key (qbid) references question_bank (id)
            on delete cascade,
    constraint mid_qbank_question_question_id_fk
        foreign key (qid) references question (id)
            on delete cascade
);

create index sjid
    on question_bank (sjid);

create index tid
    on question_bank (tid);

create table test_paper
(
    id   int auto_increment
        primary key,
    name varchar(32) not null,
    sjid int         not null,
    tid  int         not null,
    constraint test_paper_ibfk_1
        foreign key (sjid) references subject (id),
    constraint test_paper_ibfk_2
        foreign key (tid) references teacher (id)
);

create table exam
(
    id           int auto_increment
        primary key,
    name         varchar(32) not null,
    sjid         int         not null,
    cid          int         not null,
    tpid         int         null,
    start_time   datetime    not null,
    release_time datetime    not null,
    duration     time        not null,
    max_submit   int         null,
    tid          int         not null,
    constraint exam_ibfk_1
        foreign key (sjid) references subject (id),
    constraint exam_ibfk_2
        foreign key (cid) references class (id),
    constraint exam_ibfk_3
        foreign key (tpid) references test_paper (id)
            on delete cascade,
    constraint exam_ibfk_4
        foreign key (tid) references teacher (id)
);

create index cid
    on exam (cid);

create index sjid
    on exam (sjid);

create index tid
    on exam (tid);

create table mid_exam_student
(
    id                 int auto_increment
        primary key,
    eid                int           not null,
    sid                int           not null,
    score              double        null,
    start_exam_time    datetime      null,
    submitted          int default 0 not null,
    latest_submit_time datetime      null,
    constraint mid_exam_student_ibfk_1
        foreign key (eid) references exam (id)
            on delete cascade,
    constraint mid_exam_student_ibfk_2
        foreign key (sid) references student (id)
            on delete cascade
);

create table mid_exam_student_question
(
    mesid   int  not null,
    qid     int  not null,
    answers text null,
    primary key (mesid, qid),
    constraint mid_exam_student_question_mid_exam_student_id_fk
        foreign key (mesid) references mid_exam_student (id)
            on delete cascade,
    constraint mid_exam_student_question_question_id_fk
        foreign key (qid) references question (id)
            on delete cascade
);

create table mid_tpaper_qbank
(
    tpid           int                  not null,
    qbid           int                  not null,
    question_score double     default 1 not null,
    judge_type     tinyint(1) default 1 not null,
    primary key (tpid, qbid),
    constraint mid_tpaper_qbank_ibfk_1
        foreign key (tpid) references test_paper (id)
            on delete cascade,
    constraint mid_tpaper_qbank_ibfk_2
        foreign key (qbid) references question_bank (id)
            on delete cascade
);

create index sjid
    on test_paper (sjid);

create index tid
    on test_paper (tid);


