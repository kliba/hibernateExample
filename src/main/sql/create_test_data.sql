--SETTINGS
--This table will contain only one row, that contains the settings for the system.
INSERT INTO `SETTINGS`(`vat`, `weightLimit`, `owPenaltyPerKG`) VALUES (27,10,200);

--ITEM
--Contains items contained in a cart.
--Price of the item is the quantity of the product times the price of one piece.
INSERT INTO `ITEM`(`name`, `quantity`, `kgPerPiece`, `pricePerPiece`)
VALUES ('corn', 40, 1200, 1);
INSERT INTO `ITEM`(`name`, `quantity`, `kgPerPiece`, `pricePerPiece`)
VALUES ('bread', 5, 800, 400);
INSERT INTO `ITEM`(`name`, `quantity`, `kgPerPiece`, `pricePerPiece`)
VALUES ('chips', 12, 2200, 250);
