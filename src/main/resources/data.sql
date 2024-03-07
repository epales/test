TRUNCATE TABLE ability;
TRUNCATE TABLE craft_items;
TRUNCATE TABLE craft_make;
TRUNCATE TABLE items;

INSERT ability VALUES('각성',"1", "공용")
                    ,('갈증',"2", "리퍼")
                    ,('강령술',"3","공용")
                    ,('강화 무기',"4","데빌헌터")
                    ,('강화 방패',"5","공용")
                    ,('결투의 대가',"6","공용")
                    ,('고독한 기사',"7","워로드")
                    ,('광기',"8","버서커")
                    ,('광전사의 비기',"9","버서커")
                    ,('구슬동자',"10","공용")
                    ,('굳은 의지',"11","공용")
                    ,('권왕파천무',"12","브레이커")
                    ,('그믐의 경계',"13","소울이터")
                    ,('극의:체술',"14","인파이터")
                    ,('급소 타격',"15","공용")
                    ,('기습의 대가',"16","공용")
                    ,('긴급구조',"17","공용")
                    ,('넘치는 교감',"18","서머너")
                    ,('달의 소리',"19","리퍼")
                    ,('달인의 저력',"20","공용")
                    ,('돌격대장',"21","공용")
                    ,('두 번째 동료',"22","호크아이")
                    ,('마나 효율 증가',"23","공용")
                    ,('마나의 흐름',"24","공용")
                    ,('만개',"25","도화가")
                    ,('만월의 집행자',"26","소울이터")
                    ,('멈출 수 없는 충동',"27","데모닉")
                    ,('바리케이드',"28","공용")
                    ,('버스트',"29","블레이드")
                    ,('번개의 분노',"30","공용")
                    ,('부러진 뼈',"31","공용")
                    ,('분노의 망치',"32","디스트로이어")
                    ,('분쇄의 주먹',"33","공용")
                    ,('불굴',"34","공용")
                    ,('사냥의 시간',"35","건슬링어")
                    ,('상급 소환사',"36","서머너")
                    ,('선수필승',"37","공용")
                    ,('세맥타통',"38","기공사")
                    ,('속전속결',"39","공용")
                    ,('수라의 길',"40","브레이커")
                    ,('슈퍼 차지',"41","공용")
                    ,('승부사',"42","공용")
                    ,('시선 집중',"43","공용")
                    ,('실드 관통',"44","공용")
                    ,('심판자',"45","홀리나이트")
                    ,('아드레날린',"46","공용")
                    ,('아르데타인의 기술',"47","스카우터")
                    ,('안정된 상태',"48","공용")
                    ,('약자 무시',"49","공용")
                    ,('에테르 포식자',"50","공용")
                    ,('여신의 가호',"51","공용")
                    ,('역천지체',"52","기공사")
                    ,('예리한 둔기',"53","공용")
                    ,('오의 강화',"54","배틀마스터")
                    ,('오의난무',"55","스트라이커")
                    ,('완벽한 억제',"56","데모닉")
                    ,('원한',"57","공용")
                    ,('위기 모면',"58","공용")
                    ,('이슬비',"59","기상술사")
                    ,('일격필살',"60","스트라이커")
                    ,('잔재된 기운',"61","블레이드")
                    ,('저주받은 인형',"62","공용")
                    ,('전문의',"63","공용")
                    ,('전투 태세',"64","워로드")
                    ,('절실한 구원',"65","바드")
                    ,('절정',"66","창술사")
                    ,('절제',"67","창술사")
                    ,('점화',"68","소서리스")
                    ,('정기 흡수',"69","공용")
                    ,('정밀 단도',"70","공용")
                    ,('죽음의 습격',"71","호크아이")
                    ,('중갑 착용',"72","공용")
                    ,('중력 수련',"73","디스트로이어")
                    ,('진실된 용맹',"74","바드")
                    ,('진화의 유산',"75","스카우터")
                    ,('질량 증가',"76","공용")
                    ,('질풍노도',"77","기상술사")
                    ,('처단자',"78","슬레이어")
                    ,('초심',"79","배틀마스터")
                    ,('최대 마나 증가',"80","공용")
                    ,('추진력',"81","공용")
                    ,('축복의 오라',"82","홀리나이트")
                    ,('충격 단련',"83","인파이터")
                    ,('타격의 대가',"84","공용")
                    ,('탈출의 명수',"85","공용")
                    ,('포격 강화',"86","블래스터")
                    ,('포식자',"87","슬레이어")
                    ,('폭발물 전문가',"88","공용")
                    ,('피스메이커',"89","건슬링어")
                    ,('핸드거너',"90","데빌헌터")
                    ,('화력 강화',"91","블래스터")
                    ,('환류',"92","소서리스")
                    ,('황제의 칙령',"93","아르카나")
                    ,('황후의 은총',"94","아르카나")
                    ,('회귀',"95","도화가")
                    ,('공격력 감소',"96","패널티")
                    ,('공격속도 감소',"97","패널티")
                    ,('방어력 감소',"98","패널티")
                    ,('이동속도 감소',"99","패널티");

INSERT INTO craft_items(seq, code, craft_code, number) VALUES (seq,"6882201","101072","40"),
                                                              (seq,"6882204","101072","20"),
                                                              (seq,"6882207","101072","5"),
                                                              (seq,"6882704","101072","4"),
                                                              (seq,"6884307","101072","2"),
                                                              (seq,"6882101","101063","48"),
                                                              (seq,"6882104","101063","24"),
                                                              (seq,"6882107","101063","6"),
                                                              (seq,"6882304","101151","3"),
                                                              (seq,"6882201","101151","24"),
                                                              (seq,"6882204","101151","12"),
                                                              (seq,"6882207","101151","3"),
                                                              (seq,"6882201","101191","30"),
                                                              (seq,"6882204","101191","18"),
                                                              (seq,"6882207","101191","3"),
                                                              (seq,"6884407","101291","2"),
                                                              (seq,"6882101","101291","48"),
                                                              (seq,"6882104","101291","24"),
                                                              (seq,"6882107","101291","6"),
                                                              (seq,"6882704","101291","2"),
                                                              (seq,"6882304","101221","3"),
                                                              (seq,"6882201","101221","24"),
                                                              (seq,"6882204","101221","12"),
                                                              (seq,"6882207","101221","3"),
                                                              (seq,"6882401","101231","5"),
                                                              (seq,"6882201","101231","24"),
                                                              (seq,"6882204","101231","12"),
                                                              (seq,"6882207","101231","3");

INSERT INTO craft_make(code, make_number, make_price) VALUES ("101072","3","30"),
                                                             ("101063","3","30"),
                                                             ("101151","3","15"),
                                                             ("101191","3","15"),
                                                             ("101291","3","30"),
                                                             ("101221","3","15"),
                                                             ("101231","3","15");

INSERT INTO items VALUES (101063,	"정령의 회복약",	33,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_8.png",	60000,	"영웅",	1),
                         (101151,	"암흑 수류탄",	15,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_47.png",	60000,	"희귀",	1),
                         (101072,	"각성 물약",	31,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_10.png",	60000,	"영웅",	1),
                         (101221,	"회오리 수류탄",	12,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_53.png",	60000,	"희귀",	1),
                         (101191,	"성스러운 부적",	18,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_51.png",	60000,	"희귀",	1),
                         (101231,	"점토 수류탄",	14,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_54.png",	60000,	"희귀",	1),
                         (101291,	"아드로핀 물약",	37,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_72.png",	60000,	"영웅",	1),
                         (101917,	"빛나는 정령의 회복약",	83,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/battle_item/battle_item_01_80.png",	60000,	"영웅",	1),
                         (6861011,	"최상급 오레하 융화 재료",	55,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_11_29.png",	50000,	"영웅",	1),
                         (6882101,	"들꽃",	60,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_8_46.png",	90000,	"일반",	100),
                         (6882104,	"수줍은 들꽃",	4,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_4_14.png",	90000,	"고급",	10),
                         (6882107,	"화사한 들꽃",	29,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_8_47.png",	90000,	"희귀",	10),
                         (6882201,	"투박한 버섯",	32,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_8_56.png",	90000,	"일반",	100),
                         (6882204,	"싱싱한 버섯",	4,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/all_quest/all_quest_02_101.png",	90000,	"고급",	10),
                         (6882207,	"화려한 버섯",	8,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_8_57.png",	90000,	"희귀",	10),
                         (6882301,	"목재",	74,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_3_252.png",	90000,	"일반",	100),
                         (6882304,	"부드러운 목재",	16,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_3_253.png",	90000,	"고급",	10),
                         (6882401,	"철광석",	27,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_3_243.png",	90000,	"일반",	100),
                         (6882404,	"묵직한 철광석",	5,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_3_239.png",	90000,	"고급",	10),
                         (6882704,	"희귀한 유물",	11,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_4.png",	90000,	"고급",	10),
                         (6884307,	"튼튼한 목재",	74,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_4_4.png",	90000,	"희귀",	10),
                         (6884407,	"단단한 철광석",	35,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_5_76.png",	90000,	"희귀",	10),
                         (65200504,	"원한 각인서",	2795,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_24.png",	40000,	"전설",	1),
                         (65201004,	"예리한 둔기 각인서",	1338,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_24.png",	40000,	"전설",	1),
                         (65202804,	"저주받은 인형 각인서",	150, "https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_24.png",	40000,	"전설",	1),
                         (65203304,	"돌격대장 각인서",	1545,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_24.png",	40000,	"전설",	1),
                         (65203904,	"아드레날린 각인서",	999, "https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_24.png",	40000,	"전설",	1),
                         (65213723,	"[브레이커] 수라의 길 각인서",	114,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/all_quest/all_quest_01_153.png",	40000,	"영웅",	1),
                         (65213724,	"[브레이커] 수라의 길 각인서",	1980,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_24.png",	40000,	"전설",	1),
                         (65214414,	"[소울이터] 만월의 집행자 각인서",	1200,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_9_24.png",	40000,	"전설",	1),
                         (66102005,	"정제된 파괴강석",	18,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_11_15.png",	50000,	"일반",	10),
                         (66102105,	"정제된 수호강석",	3,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_11_16.png",	50000,	"일반",	10),
                         (66110223,	"경이로운 명예의 돌파석",	8,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_7_157.png",	50000,	"희귀",	1),
                         (66110224,	"찬란한 명예의 돌파석",	42,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_11_17.png",	50000,	"희귀",	1),
                         (66111121,	"태양의 은총",	36,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_7_161.png",50000,	"고급",	1),
                         (66111122,	"태양의 축복",	110,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_7_162.png",50000,	"희귀",	1),
                         (66111123,	"태양의 가호",	160,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_7_163.png",50000,	"영웅",	1),
                         (66130131,	"명예의 파편 주머니(소)",	200,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_8_225.png",	50000,	"고급",	1),
                         (66130132,	"명예의 파편 주머니(중)",	247,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_8_226.png",	50000,	"희귀",	1),
                         (66130133,	"명예의 파편 주머니(대)",	349,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_8_227.png",	50000,	"영웅",	1),
                         (66150010,	"에스더의 기운",	475000,	"https://cdn-lostark.game.onstove.com/efui_iconatlas/use/use_10_81.png",	50000,	"에스더",	1)