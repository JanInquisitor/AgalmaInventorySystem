CREATE TABLE Product
(
    ItemID       INT PRIMARY KEY,
    Name         VARCHAR(255)   NOT NULL,
    Price        DECIMAL(10, 2) NOT NULL,
    Quantity     INT            NOT NULL,
    StoragePlace INT            NOT NULL,
    AdditionDate DATE           NOT NULL,
    Barcode      VARCHAR(50)    NOT NULL,
    FOREIGN KEY (StoragePlace) REFERENCES Storage (StorageID)
);