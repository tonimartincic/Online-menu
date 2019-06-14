export const isEmpty = (obj) => {
  for ( let prop in obj ) {
    return false;
  }
  return true;
}
