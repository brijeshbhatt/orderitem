DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
`id` INT NOT NULL AUTO_INCREMENT,
`product_code` VARCHAR(30) NOT NULL,
`product_name` VARCHAR(50) NOT NULL,
`quantity` INT NOT NULL,
PRIMARY KEY (`id`)
);