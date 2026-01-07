from pistol import Pistol

class WaterPistol(Pistol):
    def __init__(self, caliber: float, magazine_capacity: int, color: str):
        super().__init__(caliber, magazine_capacity)
        self.color = color

    def shoot(self):
        if self.current_ammo > 0:
            self.current_ammo -= 1
            print(f"Пшш! Вистріл водою ({self.color}). Залишилось пострілів:", self.current_ammo)
        else:
            print("Пістолет порожній, треба долити воду.")