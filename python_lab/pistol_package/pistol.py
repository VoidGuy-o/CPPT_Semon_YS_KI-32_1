class Pistol:
    def __init__(self, caliber: float, magazine_capacity: int):
        self.caliber = caliber
        self.magazine_capacity = magazine_capacity
        self.current_ammo = magazine_capacity

    def shoot(self):
        if self.current_ammo > 0:
            self.current_ammo -= 1
            print("Бах! Залишилось куль:", self.current_ammo)
        else:
            print("Магазин порожній!")

    def reload(self):
        self.current_ammo = self.magazine_capacity
        print("Пістолет перезаряджено.")