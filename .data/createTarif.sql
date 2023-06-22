CREATE TABLE "public.Станция" (   "Имя_Пргрф" varchar(255),
                                  "Мнкод" varchar(255) NOT NULL ,
                                  "Стрнц1" varchar(255),   "Стрк1" varchar(255),
                                  "Участок" varchar(255),   "ЕСР6" varchar(255),
                                  "Имя" varchar(255),   "Пргрф" varchar(255),
                                  "Стрнц2" varchar(255),   "Стрк2" varchar(255),
                                  "Колонка" varchar(255),   "КД" varchar(255),
                                  "N_ТП" integer,   CONSTRAINT "Станция_pk" PRIMARY KEY ("ЕСР6")
) WITH (  OIDS=FALSE
    );


CREATE TABLE "public.Дорога" (   "ИМЯ_Д" varchar(255),
                                 "АДРЕС" varchar(255),   "ЕСР_Д" varchar(255),
                                 "МНКОД" varchar(255) UNIQUE,   "СТРН1_1" varchar(255),
                                 "СТРН1_2" varchar(255),
                                 "СТРК1_2" varchar(255),   "ЕСР_Н" varchar(255),
                                 "ЕСР_К" varchar(255),   "НПП" varchar(255),
                                 "КД" varchar(255) UNIQUE NOT NULL ,   CONSTRAINT "Дорога_pk" PRIMARY KEY ("МНКОД")
) WITH (  OIDS=FALSE
    );

CREATE TABLE "public.Участок" (
                                  "Ид_у" varchar(255) UNIQUE NOT NULL ,   "Ид_д" varchar(255) NOT NULL ,
                                  "Страница1" varchar(255),   "Строка1" varchar(255),
                                  "Название" varchar(255),   "Кол_стан" varchar(255),
                                  "Кол_узл" varchar(255),   "Длина" varchar(255),
                                  "ЕСР_Н" varchar(255),   "ЕСР_К" varchar(255),
                                  "ТП_Н" varchar(255),   "ТП_К" varchar(255),
                                  CONSTRAINT "Участок_pk" PRIMARY KEY ("Ид_у")
) WITH (  OIDS=FALSE
    );

CREATE TABLE "public.ТП" (
                             "N_ТП" integer UNIQUE NOT NULL ,   "Имя_ТП" varchar(255),
                             "ЕСР" varchar(255),   CONSTRAINT "ТП_pk" PRIMARY KEY ("N_ТП")
) WITH (  OIDS=FALSE
    );

CREATE TABLE "public.ТП_1" (
                             "N_ТП" integer UNIQUE NOT NULL ,   "Имя_ТП" varchar(255),
                             "ЕСР" varchar(255),   CONSTRAINT "ТП_pk1" PRIMARY KEY ("N_ТП")
) WITH (  OIDS=FALSE
    );

CREATE TABLE "public.Расстояния" (   "N_ТП" integer,
                                     "ТП_до" integer,   "Таблица" varchar(255),
                                     "Страница" varchar(255),   "Расстояние" integer,
                                     "Вид_коорд" varchar(255),   CONSTRAINT "Расстояния_pk" PRIMARY KEY ("N_ТП","ТП_до")
) WITH (  OIDS=FALSE
    );

CREATE TABLE "public.Стан_Уч" (
                                  "Ид_сту" varchar(255),   "Ид_у" varchar(255),
                                  "Страница" varchar(255),   "Нпп" varchar(255),
                                  "Код_с" varchar(255) UNIQUE NOT NULL ,   "Имя_с" varchar(255),
                                  "раст_нач" varchar(255),   "расст_кон" varchar(255),
                                  "расст_тп1" varchar(255),   "расст_тп2" varchar(255),
                                  CONSTRAINT "Стан_Уч_pk" PRIMARY KEY ("Ид_сту")) WITH (
                                                                                      OIDS=FALSE);
ALTER TABLE "public.Расстояния" ADD CONSTRAINT "Расстояния_fk0" FOREIGN KEY ("N_ТП") REFERENCES "public.ТП"("N_ТП");
ALTER TABLE "public.Расстояния" ADD CONSTRAINT "Расстояния_fk1" FOREIGN KEY ("ТП_до") REFERENCES "public.ТП_1"("N_ТП");
ALTER TABLE "public.Стан_Уч" ADD CONSTRAINT "Стан_Уч_fk0" FOREIGN KEY ("Ид_у") REFERENCES "public.Участок"("Ид_у");
ALTER TABLE "public.Стан_Уч" ADD CONSTRAINT "Стан_Уч_fk1" FOREIGN KEY ("Код_с") REFERENCES "public.Станция"("ЕСР6");
ALTER TABLE "public.Участок" ADD CONSTRAINT "Участок_fk1" FOREIGN KEY ("Ид_д") REFERENCES "public.Дорога"("КД");
ALTER TABLE "public.Станция" ADD CONSTRAINT "Станция_fk0" FOREIGN KEY ("Мнкод") REFERENCES "public.Дорога"("МНКОД");
ALTER TABLE "public.Станция" ADD CONSTRAINT "Станция_fk1" FOREIGN KEY ("N_ТП") REFERENCES "public.ТП"("N_ТП");