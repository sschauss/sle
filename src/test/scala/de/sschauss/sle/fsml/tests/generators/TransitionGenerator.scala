package de.sschauss.sle.fsml.tests.generators

import org.scalacheck.Gen
import de.sschauss.sle.fsml.Ast._

object TransitionGenerator {

  def transition = for {
    input <- Gen.identifier
    action <- Gen.option(Gen.identifier)
    id <- Gen.option(Gen.identifier)
  } yield Transition(input, action, id)

  def transition(input: Name) = for {
    action <- Gen.option(Gen.identifier)
    id <- Gen.option(Gen.identifier)
  } yield Transition(input, action, id)

  def transition(ids: List[Name]) = for {
    input <- Gen.identifier
    action <- Gen.option(Gen.identifier)
    id <- Gen.option(Gen.oneOf(ids))
  } yield Transition(input, action, id)

  def transition(input: Name, ids: List[Name]) = for {
    action <- Gen.option(Gen.identifier)
    id <- Gen.option(Gen.oneOf(ids))
  } yield Transition(input, action, id)


}
