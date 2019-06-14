import React from 'react';
import styles from './pageHeader.css';

const PageHeader = () => (
  <section className={styles.sectionTitle}>
    <span className={styles.letter} data-letter="O">O</span>
    <span className={styles.letter} data-letter="n">n</span>
    <span className={styles.letter} data-letter="l">l</span>
    <span className={styles.letter} data-letter="i">i</span>
    <span className={styles.letter} data-letter="n">n</span>
    <span className={styles.letter} data-letter="e">e</span>
    <span className={styles.letter} data-letter="-">-</span>
    <span className={styles.letter} data-letter="m">m</span>
    <span className={styles.letter} data-letter="e">e</span>
    <span className={styles.letter} data-letter="n">n</span>
    <span className={styles.letter} data-letter="u">u</span>
  </section>
);

export default PageHeader;
