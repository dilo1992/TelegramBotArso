create table products
(
    id                       bigint auto_increment
        primary key,
    model_of_type_of_product varchar(255) null,
    price                    double       null,
    type_of_product          varchar(255) null,
    information              varchar(255) null
);

INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M100', 88, 'Concrete', 'Concrete M100 is used for repair and construction work. Concrete meets international requirements and standards. To work with it does not require the use of special equipment. The material is comfortable to work')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M150', 90, 'Concrete', 'Concrete of this brand is not distinguished by resistance to loads')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M200', 95, 'Concrete', 'It has found application in almost all construction areas. It can also be used for the construction of buildings')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M250', 100, 'Concrete', 'This mixture of concrete is used for decoration')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M300', 105, 'Concrete', 'The area of use of concrete mixtures are building structures, which during operation will be subject to significant loads. Therefore, the most important characteristic of concrete is strength, that is, the ability to withstand congestion.')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M350', 135, 'Concrete', 'This brand of concrete belongs to the building materials that are part of the middle section.')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M400', 140, 'Concrete', 'The construction of structures that are subject to special requirements in the field of overall reliability')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M450', 145, 'Concrete', 'M450 concrete is considered not a very popular material in the construction of houses')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M500', 150, 'Concrete', 'Concrete M500 is able to withstand maximum loads. Most often')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('F200', 360, 'CFB block', 'Dimensions (length/width/height): 3000x1500x170 mm')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('F250', 390, 'CFB block', 'Dimensions (length/width/height): 3000x1750x170 mm, Weight: 2.16 tons')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M50', 70, 'CEMENT', 'M50 cement mortar is used for the manufacture of concrete slabs, floor coverings, tiles, clinker bricks.')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M75', 75, 'CEMENT', 'Most often, cement mortar M75 is used for the construction of partitions, external / external walls, reinforcement of drainage layers, laying of foundation blocks, installation of screeds, and construction of low-rise houses.')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M100', 80, 'CEMENT', 'Masonry mortar M100 is a building material used for filling joints in walls, assembling structures from panels, installation of columns, walls, plastering surfaces')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M150', 85, 'CEMENT', 'The optimal solution is to use this product for grouting and masonry work, forming a screed in places of high humidity, on “weak” soil.')
INSERT INTO tg.products (model_of_type_of_product, price, type_of_product, information) VALUES ('M200', 90, 'CEMENT', 'M200 is suitable for laying walls')