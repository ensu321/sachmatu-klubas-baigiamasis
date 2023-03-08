import { savePlayer } from "../../../Commons/requests.js";

const handleFormSubmit = async () => {
  const form = document.getElementById("addPlayerForm").querySelector("form");
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const player = {
        email: form.playerEmail.value,
        firstName: form.playerName.value,
        lastName: form.playerSurname.value,
        personalCode: form.playerPersonalCode.value,
        startDate: form.playerStartDate.value
    };
    await savePlayer(player);
    window.location.reload();
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../list-players/list-players.html");
  });
};

(async () => {
  handleCancelButton();
  await handleFormSubmit();
})();
