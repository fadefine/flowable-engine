update ACT_GE_PROPERTY set VALUE_ = '6.0.1.0' where NAME_ = 'schema.version';

update ACT_ID_PROPERTY set VALUE_ = '6.0.1.0' where NAME_ = 'schema.version';

UPDATE ACT_DMN_DATABASECHANGELOGLOCK SET LOCKED = TRUE, LOCKEDBY = '192.168.1.5 (192.168.1.5)', LOCKGRANTED = '2019-03-14 14:47:13.875' WHERE ID = 1 AND LOCKED = FALSE;

UPDATE ACT_DMN_DATABASECHANGELOGLOCK SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;


UPDATE ACT_FO_DATABASECHANGELOGLOCK SET LOCKED = TRUE, LOCKEDBY = '192.168.1.5 (192.168.1.5)', LOCKGRANTED = '2019-03-14 14:47:14.461' WHERE ID = 1 AND LOCKED = FALSE;

UPDATE ACT_FO_DATABASECHANGELOGLOCK SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;


UPDATE ACT_CO_DATABASECHANGELOGLOCK SET LOCKED = TRUE, LOCKEDBY = '192.168.1.5 (192.168.1.5)', LOCKGRANTED = '2019-03-14 14:47:14.547' WHERE ID = 1 AND LOCKED = FALSE;

UPDATE ACT_CO_DATABASECHANGELOGLOCK SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

