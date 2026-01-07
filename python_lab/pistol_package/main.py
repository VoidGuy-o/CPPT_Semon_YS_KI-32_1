from water_pistol import WaterPistol

def main():
    pistol = WaterPistol(0.5, 5, "синій")
    pistol.shoot()
    pistol.shoot()
    pistol.reload()
    pistol.shoot()

if __name__ == "__main__":
    main()