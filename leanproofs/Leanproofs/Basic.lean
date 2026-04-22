import Mathlib.Combinatorics.Enumerative.InclusionExclusion
import Mathlib.Probability.ProductMeasure

section

def d : Nat → Nat → ℝ := sorry
def R : Nat → Nat → Prop := sorry

theorem d.pos (x : Nat) : d x x = 0 := by sorry
theorem d.sym (x : Nat) : d x y = d y x := by sorry

theorem R.refl (x : Nat) : R x x := by sorry
theorem R.sym (x y : Nat) : R x y ↔ R y x := by sorry
theorem R.trans (x y z : Nat) : R x y → R y z →  R x z := by sorry

example : { (x,y) | d x y > t ∧ R x y} = { (x,y) | d x y > t} ∩ { (x,y) | R x y} := by
    ext;
    simp

example : { (x,y) | R x y} ∪ { (x,y) | ¬ R x y} = {(x,y)}  := by
    apply prop
    

end 
